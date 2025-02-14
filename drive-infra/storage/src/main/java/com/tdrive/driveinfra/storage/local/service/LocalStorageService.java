package com.tdrive.driveinfra.storage.local.service;

import com.tdrive.drivedomain.storage.service.StorageService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "storage.type", havingValue = "local")
public class LocalStorageService implements StorageService {

    @Override
    public void get() {
        System.out.println("call LocalStorageService get");
    }
}
