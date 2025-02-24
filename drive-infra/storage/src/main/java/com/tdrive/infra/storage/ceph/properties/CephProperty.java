package com.tdrive.infra.storage.ceph.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties("storage.ceph.rgw")
public class CephProperty {
    private final String endpoint;
    private final String accessKey;
    private final String secretKey;
}
