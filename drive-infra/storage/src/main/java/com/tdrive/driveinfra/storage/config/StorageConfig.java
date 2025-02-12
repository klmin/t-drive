package com.tdrive.driveinfra.storage.config;

import com.tdrive.drivecore.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class StorageConfig {

//    @Value("${storage.type:ceph}") // 기본값: ceph
//    private String storageType;
//
//    @Bean
//    @Primary
//    public StorageService primaryStorageService(
//            @Qualifier("cephStorageService") StorageService cephStorageService,
//            @Qualifier("localStorageService") StorageService localStorageService) {
//
//        if ("local".equalsIgnoreCase(storageType)) {
//            System.out.println("Using LocalStorageService as Primary");
//            return localStorageService;
//        } else {
//            System.out.println("Using CephStorageService as Primary (Default)");
//            return cephStorageService;
//        }
//    }

}
