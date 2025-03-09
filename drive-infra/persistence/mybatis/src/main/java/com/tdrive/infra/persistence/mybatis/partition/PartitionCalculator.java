package com.tdrive.infra.persistence.mybatis.partition;

import com.tdrive.infra.persistence.mybatis.partition.properties.PartitionProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PartitionCalculator {

    private final PartitionProperty partitionProperty;

    public int calculateTableNumber(Number seq) {
        if (seq == null || seq.longValue() == 0) {
            throw new IllegalArgumentException("seq is null");
        }
        return (int) ((seq.longValue() - 1) % partitionProperty.getTableCount()) + 1;
    }

}
