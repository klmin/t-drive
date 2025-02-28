package com.tdrive.mybatis.persistence.mybatis.resource.converter;

import com.tdrive.domain.resource.model.Resource;
import com.tdrive.mybatis.persistence.mybatis.resource.entity.ResourceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResourceConverter {

    Resource toDomain(ResourceEntity entity);
    ResourceEntity toEntity(Resource resource);

}
