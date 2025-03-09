package com.tdrive.infra.persistence.mybatis.partition.interceptor;

import com.tdrive.infra.persistence.mybatis.partition.PartitionCalculator;
import com.tdrive.infra.persistence.mybatis.partition.PartitionSupport;
import com.tdrive.infra.persistence.mybatis.partition.annotation.TablePartition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
@RequiredArgsConstructor
public class PartitionInterceptor implements Interceptor {

    private final PartitionCalculator partitionCalculator;
    private final Map<String, TablePartition> annotationCache = new ConcurrentHashMap<>();
    private static final String TABLE_NUMBER = "tableNumber";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        log.info("## interceptor ##");

        Object[] args = invocation.getArgs();
        Object parameter = args[1];

        if (parameter instanceof PartitionSupport partitionSupport) {
            handlePartitionLogic(partitionSupport);
            return invocation.proceed();
        }

        MappedStatement ms = (MappedStatement) args[0];

        TablePartition tablePartition = getCachedTablePartition(ms);
        if (tablePartition != null) {
            handlePartitionLogic(parameter, tablePartition);
        }

        return invocation.proceed();
    }

    private void handlePartitionLogic(PartitionSupport partitionSupport) {
        Number userSeq = partitionSupport.getPartitionKey();
        int tableNumber = partitionCalculator.calculateTableNumber(userSeq);
        partitionSupport.setTableNumber(tableNumber);
    }

    private void handlePartitionLogic(Object parameter, TablePartition tablePartition) {
        MetaObject metaObject = SystemMetaObject.forObject(parameter);
        String partitionKey = tablePartition.partitionKey();
        Number userSeq = (Number) metaObject.getValue(partitionKey);
        int tableNumber = partitionCalculator.calculateTableNumber(userSeq);
        metaObject.setValue(TABLE_NUMBER, tableNumber);
    }

    private TablePartition getCachedTablePartition(MappedStatement ms) {
        String msId = ms.getId();
        return annotationCache.computeIfAbsent(msId, key -> {
            try {
                String mapperClassName = msId.substring(0, msId.lastIndexOf("."));
                Class<?> mapperClass = Class.forName(mapperClassName);
                String methodName = msId.substring(msId.lastIndexOf(".") + 1);

                for (var method : mapperClass.getDeclaredMethods()) {
                    if (method.getName().equals(methodName) && method.isAnnotationPresent(TablePartition.class)) {
                        return method.getAnnotation(TablePartition.class);
                    }
                }

                if (mapperClass.isAnnotationPresent(TablePartition.class)) {
                    return mapperClass.getAnnotation(TablePartition.class);
                }

                return null;
            } catch (ClassNotFoundException e) {
                log.error("Failed to load mapper class for ID: {}", msId, e);
                return null;
            }
        });
    }


}
