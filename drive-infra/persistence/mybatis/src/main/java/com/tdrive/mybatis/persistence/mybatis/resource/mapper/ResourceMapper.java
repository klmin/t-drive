package com.tdrive.mybatis.persistence.mybatis.resource.mapper;

import com.tdrive.mybatis.persistence.mybatis.resource.entity.ResourceEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResourceMapper {

    int insert(ResourceEntity entity);
    int insertTableNumber(ResourceEntity entity);

}
