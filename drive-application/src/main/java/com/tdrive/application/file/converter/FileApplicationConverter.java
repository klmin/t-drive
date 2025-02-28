package com.tdrive.application.file.converter;

import com.tdrive.application.file.dto.FileUploadDto;
import com.tdrive.domain.resource.enums.ResourceType;
import com.tdrive.domain.resource.model.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = ResourceType.class)
public interface FileApplicationConverter {

    @Mapping(target = "resourceType", expression = "java(ResourceType.FILE)")
    Resource toResource(FileUploadDto dto);


}
