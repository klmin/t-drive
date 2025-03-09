package com.tdrive.infra.persistence.mybatis.partition;

import com.tdrive.infra.persistence.mybatis.partition.properties.PartitionProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PartitionCalculator {

    private final PartitionProperty partitionProperty;

    public int calculateTableNumber(Integer seq) {
        if (seq == null || seq == 0) {
            throw new IllegalArgumentException("seq is null");
        }
        return ((seq - 1) % partitionProperty.getTableCount()) + 1;
    }

}
