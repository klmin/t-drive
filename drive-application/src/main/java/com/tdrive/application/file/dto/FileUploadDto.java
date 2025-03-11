package com.tdrive.application.file.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@ToString
public class FileUploadDto {

    private Integer userSeq;
    private Long parentFolderSeq;
    private String resourceName;
    private String ext;
    private String mimeType;
    private Long sizeByte;
    private MultipartFile file;
}
