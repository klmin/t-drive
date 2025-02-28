package com.tdrive.application.file.dto;

import com.tdrive.domain.resource.enums.ResourceType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

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
}
