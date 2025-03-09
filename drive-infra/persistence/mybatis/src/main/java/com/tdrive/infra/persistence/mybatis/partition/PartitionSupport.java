package com.tdrive.infra.persistence.mybatis.partition;

public interface PartitionSupport {
    Number getPartitionKey();
    void setTableNumber(Integer tableNumber);
}
