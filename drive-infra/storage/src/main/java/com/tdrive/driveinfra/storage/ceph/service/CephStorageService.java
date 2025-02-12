package com.tdrive.driveinfra.storage.ceph.service;

import com.tdrive.drivecore.storage.service.StorageService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "storage.type", havingValue = "ceph", matchIfMissing = true)
public class CephStorageService implements StorageService {

    @Override
    public void get() {
        System.out.println("Ceph Storage Service");
    }
}
