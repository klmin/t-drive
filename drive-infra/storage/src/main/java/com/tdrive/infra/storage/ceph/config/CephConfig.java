package com.tdrive.infra.storage.ceph.config;

import com.tdrive.infra.storage.ceph.properties.CephProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;

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
                .serviceConfiguration(S3Configuration.Builder::pathStyleAccessEnabled)
                .region(Region.US_EAST_1)
                .build();
    }
}
