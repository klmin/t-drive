package com.tdrive.infra.persistence.mybatis.partition.properties;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties("partition")
public class PartitionProperty {
    private final int tableCount;
}
