package com.tdrive.mybatis.persistence.mybatis.resource.repository;

import com.tdrive.domain.resource.model.Resource;
import com.tdrive.domain.resource.repository.ResourceRepository;
import com.tdrive.mybatis.persistence.mybatis.resource.converter.ResourceConverter;
import com.tdrive.mybatis.persistence.mybatis.resource.entity.ResourceEntity;
import com.tdrive.mybatis.persistence.mybatis.resource.mapper.ResourceMapper;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ResourceRepositoryImpl implements ResourceRepository {

    private final ResourceMapper mapper;
    private final ResourceConverter converter;
    @Value("${table.count}")
    private int tableCount;

    private int calculateTableNumber(Integer userSeq) {
        if (userSeq == null) {
            throw new IllegalArgumentException("userSeq is null");
        }
        return ((userSeq - 1) % tableCount) + 1;
    }

    @Override
    public Resource insert(Resource resource) {
        System.out.println("call MyBatis FileRepositoryImpl insert");
        var entity = converter.toEntity(resource);
        var tableNumber = calculateTableNumber(resource.getUserSeq());
        mapper.insertByTable(entity, tableNumber);
        return converter.toDomain(entity);

    }

    @Override
    public Resource updateResourceName(Resource resource) {
        System.out.println("call MyBatis FileRepositoryImpl updateResourceName");
        var tableNumber = calculateTableNumber(resource.getUserSeq());
        var entity = converter.toEntity(resource);
        mapper.updateResourceSaveNameByTable(entity, tableNumber);
        return converter.toDomain(entity);
    }



}
