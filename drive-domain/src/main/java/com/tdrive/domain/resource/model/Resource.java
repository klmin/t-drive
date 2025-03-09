package com.tdrive.domain.resource.model;


import com.tdrive.domain.resource.enums.ResourceType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class Resource {

    private Long resourceSeq;
    private Integer userSeq;
    private ResourceType resourceType;
    private Long parentFolderSeq;
    private String resourceName;
    private String resourceSaveName;
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

    public void initResourceSaveName() {
        if (userSeq == null || resourceSeq == null) {
            throw new IllegalStateException("userSeq or resourceSeq is null");
        }
        this.resourceSaveName = userSeq + "/" + resourceSeq;
    }

}
