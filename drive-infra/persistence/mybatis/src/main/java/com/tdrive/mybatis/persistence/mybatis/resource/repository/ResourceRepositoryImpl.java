package com.tdrive.mybatis.persistence.mybatis.resource.repository;

import com.tdrive.domain.resource.model.Resource;
import com.tdrive.domain.resource.repository.ResourceRepository;
import com.tdrive.mybatis.persistence.mybatis.resource.converter.ResourceConverter;
import com.tdrive.mybatis.persistence.mybatis.resource.mapper.ResourceMapper;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ResourceRepositoryImpl implements ResourceRepository {

    private final ResourceMapper mapper;
    private final ResourceConverter converter;

    @Override
    public int insert(Resource resource) {
        System.out.println("call MyBatis FileRepositoryImpl insert");
        var entity = converter.toEntity(resource);
        var insertResult = mapper.insert(entity);
        var insertTableNumberResult = mapper.insertTableNumber(entity);
        System.out.println("entity.getResourceSeq() : " + entity.getResourceSeq());
        System.out.println("insertResult : " + insertResult);
        System.out.println("insertTableNumberResult : " + insertTableNumberResult);
        return 0;
    }
}
