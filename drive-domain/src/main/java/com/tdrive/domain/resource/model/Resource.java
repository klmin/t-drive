package com.tdrive.domain.resource.model;


import com.tdrive.domain.resource.enums.ResourceType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Resource {

    private Long resourceSeq;
    private Integer userSeq;
    private ResourceType resourceType;
    private Long parentFolderSeq;
    private String resourceName;
    private Boolean isDelete;
    private LocalDateTime deleteDate;
    private String path;
    private String ext;
    private String mimeType;
    private Long sizeByte;
    private Long registerUserSeq;
    private LocalDateTime registerDate;
    private Long updateUserSeq;
    private LocalDateTime updateDate;

}
