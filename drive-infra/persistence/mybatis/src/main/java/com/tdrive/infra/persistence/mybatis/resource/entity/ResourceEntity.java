package com.tdrive.infra.persistence.mybatis.resource.entity;

import com.tdrive.domain.resource.enums.ResourceType;
import com.tdrive.infra.persistence.mybatis.partition.PartitionSupport;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class ResourceEntity implements PartitionSupport {

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

    private Integer tableNumber;

    @Override
    public Number getPartitionKey() {
        return userSeq.longValue();
    }

    @Override
    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }
}
