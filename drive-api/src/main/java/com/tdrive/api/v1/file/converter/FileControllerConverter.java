package com.tdrive.api.v1.file.converter;

import com.tdrive.api.v1.file.request.FileUploadRequest;
import com.tdrive.api.v1.file.response.FileUploadResponse;
import com.tdrive.application.file.dto.FileUploadDto;
import com.tdrive.application.file.dto.FileUploadResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface FileControllerConverter {

    FileUploadDto toDto(FileUploadRequest request);
    FileUploadResponse toResponse(FileUploadResponseDto responseDto);
}
