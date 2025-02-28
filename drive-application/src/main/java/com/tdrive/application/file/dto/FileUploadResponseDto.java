package com.tdrive.application.file.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FileUploadResponseDto {
    private String fileName;
}
