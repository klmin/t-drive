package com.tdrive.infra.persistence.mybatis.resource.repository;

import com.tdrive.domain.resource.model.Resource;
import com.tdrive.domain.resource.repository.ResourceRepository;
import com.tdrive.infra.persistence.mybatis.resource.converter.ResourceConverter;
import com.tdrive.infra.persistence.mybatis.resource.mapper.ResourceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ResourceRepositoryImpl implements ResourceRepository {

    private final ResourceMapper mapper;
    private final ResourceConverter converter;

    @Override
    public Resource insert(Resource resource) {
        System.out.println("call MyBatis FileRepositoryImpl insert");

        var entity = converter.toEntity(resource);

        mapper.insertByTable(entity);
        return converter.toDomain(entity);

    }

    @Override
    public Resource updateResourceName(Resource resource) {
        System.out.println("call MyBatis FileRepositoryImpl updateResourceName");

        var entity = converter.toEntity(resource);

        mapper.updateResourceSaveNameByTable(entity);
        return converter.toDomain(entity);
    }
}
