package com.tdrive.infra.persistence.mybatis.resource.repository;

import com.tdrive.domain.resource.model.Resource;
import com.tdrive.domain.resource.repository.ResourceRepository;
import com.tdrive.infra.persistence.mybatis.partition.PartitionCalculator;
import com.tdrive.infra.persistence.mybatis.resource.converter.ResourceConverter;
import com.tdrive.infra.persistence.mybatis.resource.mapper.ResourceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ResourceRepositoryImpl implements ResourceRepository {

    private final ResourceMapper mapper;
    private final ResourceConverter converter;
    private final PartitionCalculator partitionCalculator;

    @Override
    public Resource insert(Resource resource) {
        System.out.println("call MyBatis FileRepositoryImpl insert");
        var entity = converter.toEntity(resource);
        var tableNumber = partitionCalculator.calculateTableNumber(resource.getUserSeq());
        mapper.insertByTable(entity, tableNumber);
        return converter.toDomain(entity);

    }

    @Override
    public Resource updateResourceName(Resource resource) {
        System.out.println("call MyBatis FileRepositoryImpl updateResourceName");
        var tableNumber = partitionCalculator.calculateTableNumber(resource.getUserSeq());
        var entity = converter.toEntity(resource);
        mapper.updateResourceSaveNameByTable(entity, tableNumber);
        return converter.toDomain(entity);
    }
}
