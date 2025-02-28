package com.tdrive.application.file.converter;

import com.tdrive.application.file.dto.FileUploadDto;
import com.tdrive.domain.resource.model.Resource;
import org.mapstruct.Mapper;

@Mapper
public interface FileApplicationConverter {

    Resource toResource(FileUploadDto dto);


}
