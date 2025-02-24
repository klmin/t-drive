package com.tdrive.bootstrap;



import com.tdrive.application.file.usecase.FileUploadUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class BeanChecker implements ApplicationRunner {

    private final ApplicationContext context;
    private final FileUploadUseCase fileUploadUseCase;
    private final DataSource dataSource;

    @Override
    public void run(ApplicationArguments args)  {
        fileUploadUseCase.upload();

        try(Connection connection = dataSource.getConnection()){
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("metaData.getConnection().getSchema() : " + metaData.getConnection().getSchema());
            System.out.println("metaData.getURL() : " + metaData.getURL());
            System.out.println("metaData.getDatabaseProductName() : " + metaData.getDatabaseProductName());
            System.out.println("metaData.getDatabaseProductVersion() : " + metaData.getDatabaseProductVersion());
            System.out.println("metaData.getDriverName() : " + metaData.getDriverName());
            System.out.println("metaData.getUserName() : " + metaData.getUserName());
        }catch(SQLException e){
            System.err.println("❌ Failed to get DataSource info: " + e.getMessage());
        }
//        System.out.println("========== 등록된 StorageService 빈 ==========");
//        String[] storageBeans = context.getBeanNamesForType(StorageService.class);
//        for (String bean : storageBeans) {
//            System.out.println("등록된 빈: " + bean);
//        }
    }
}
