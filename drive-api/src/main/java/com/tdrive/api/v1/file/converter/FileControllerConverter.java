package com.tdrive.api.v1.file.converter;

import com.tdrive.api.v1.file.request.FileUploadRequest;
import com.tdrive.api.v1.file.response.FileUploadResponse;
import com.tdrive.application.file.dto.FileUploadDto;
import com.tdrive.application.file.dto.FileUploadResponseDto;
import com.tdrive.application.file.util.FileExtractResultDto;
import com.tdrive.application.file.util.FileUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FileControllerConverter {

    @Mapping(target = "userSeq", source = "request.userSeq")
    @Mapping(target = "parentFolderSeq", source = "request.parentFolderSeq")
    @Mapping(target = "resourceName", source = "extracted.fileName")
    @Mapping(target = "ext", source = "extracted.ext")
    @Mapping(target = "mimeType", source = "extracted.mimeType")
    @Mapping(target = "sizeByte", source = "extracted.sizeByte")
    FileUploadDto convertToDto(FileUploadRequest request, FileExtractResultDto extracted);

    FileUploadResponse toResponse(FileUploadResponseDto responseDto);

    default FileUploadDto toDto(FileUploadRequest request) {
        FileExtractResultDto extracted = FileUtil.extract(request.file());
        return convertToDto(request, extracted);
    }
}
