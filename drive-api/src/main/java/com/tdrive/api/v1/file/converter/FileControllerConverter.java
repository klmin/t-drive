package com.tdrive.api.v1.file.converter;

import com.tdrive.api.v1.file.request.FileUploadRequest;
import com.tdrive.api.v1.file.response.FileUploadResponse;
import com.tdrive.application.file.dto.FileUploadDto;
import com.tdrive.application.file.dto.FileUploadResponseDto;
import com.tdrive.application.file.util.FileExtractResultDto;
import com.tdrive.application.file.util.FileUtil;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper(componentModel = "spring")
public interface FileControllerConverter {

    @Mapping(target = "userSeq", source = "request.userSeq")
    @Mapping(target = "parentFolderSeq", source = "request.parentFolderSeq")
    @Mapping(target = "resourceName", source = "extracted.fileName")
    @Mapping(target = "ext", source = "extracted.ext")
    @Mapping(target = "mimeType", source = "extracted.mimeType")
    @Mapping(target = "sizeByte", source = "extracted.sizeByte")
    FileUploadDto convertToDto(MultipartFile file, FileUploadRequest request, FileExtractResultDto extracted);

    FileUploadResponse toResponse(FileUploadResponseDto responseDto);

    default FileUploadDto toDto(MultipartFile file, FileUploadRequest request) {
        FileExtractResultDto extracted = FileUtil.extract(file);
        return convertToDto(file, request, extracted);
    }
}
