package com.tdrive.infra.persistence.mybatis.resource.mapper;

import com.tdrive.infra.persistence.mybatis.resource.entity.ResourceEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResourceMapper {

    int insert(ResourceEntity entity);
    int insertByTable(ResourceEntity entity, int tableNumber);
    int updateResourceSaveName(ResourceEntity entity);
    int updateResourceSaveNameByTable(ResourceEntity entity, int tableNumber);

}
