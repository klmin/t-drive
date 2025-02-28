package com.tdrive.application.file.util;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileExtractResultDto {
    private String fileName;
    private String ext;
    private String mimeType;
    private Long sizeByte;
    private byte[] fileData;

    public FileExtractResultDto(String fileName, String ext, String mimeType, Long sizeByte, byte[] fileData) {
        this.fileName = fileName;
        this.ext = ext;
        this.mimeType = mimeType;
        this.sizeByte = sizeByte;
        this.fileData = fileData;
    }
}
