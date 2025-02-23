package com.tdrive.driveinfra.storage.ceph.service;

import com.tdrive.drivedomain.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;

@ConditionalOnProperty(name = "storage.type", havingValue = "ceph", matchIfMissing = true)
@Service
@RequiredArgsConstructor
public class CephStorageService implements StorageService {

    private final S3Client s3Client;

    @Override
    public void get() {

        System.out.println("call CephStorageService get");
        s3Client.serviceClientConfiguration().endpointOverride().ifPresent(uri -> {
            System.out.println("S3Client Endpoint - Full URI: " + uri.toString());
            System.out.println("Scheme (Protocol): " + uri.getScheme()); // 예: "http"
            System.out.println("Host: " + uri.getHost()); // 예: "192.168.10.102"
            System.out.println("Port: " + uri.getPort()); // 예: 80 (기본값) 또는 지정된 포트
            System.out.println("Path: " + uri.getPath()); // 예: "" (기본적으로 비어 있음)
            System.out.println("Query: " + uri.getQuery()); // 쿼리 파라미터, 없으면 null
            System.out.println("Fragment: " + uri.getFragment()); // 프래그먼트, 없으면 null
            System.out.println("User Info: " + uri.getUserInfo()); // 사용자 정보, 없으면 null
            System.out.println("Authority: " + uri.getAuthority()); // 예: "192.168.10.102:80"
            System.out.println("Raw Path: " + uri.getRawPath()); // 인코딩되지 않은 경로
            System.out.println("Raw Query: " + uri.getRawQuery()); // 인코딩되지 않은 쿼리
            System.out.println("Raw Fragment: " + uri.getRawFragment()); // 인코딩되지 않은 프래그먼트
        });

        // 다른 S3Client 설정도 출력
        System.out.println("S3Client Region: " + s3Client.serviceClientConfiguration().region());
        System.out.println("S3Client Credentials Provider: " + s3Client.serviceClientConfiguration().credentialsProvider()
                .getClass().getName() + " - " + s3Client.serviceClientConfiguration().credentialsProvider());
    }
}
