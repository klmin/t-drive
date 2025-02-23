package com.tdrive.driveinfra.storage.ceph.config;

import com.tdrive.driveinfra.storage.ceph.properties.CephProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

@Configuration
@RequiredArgsConstructor
public class CephConfig {

    private final CephProperty cephProperty;

    @Bean
    public S3Client s3Client() {
        AwsBasicCredentials credentials = AwsBasicCredentials.create(cephProperty.getAccessKey(), cephProperty.getSecretKey());
        return S3Client.builder()
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .endpointOverride(URI.create(cephProperty.getEndpoint()))
                .region(Region.US_EAST_1)
                .build();
    }
}
