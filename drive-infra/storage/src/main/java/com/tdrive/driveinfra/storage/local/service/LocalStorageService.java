package com.tdrive.driveinfra.storage.local.service;

import com.tdrive.drivedomain.storage.service.StorageService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@ConditionalOnProperty(name = "storage.type", havingValue = "local")
public class LocalStorageService implements StorageService {


    @Override
    public void upload(InputStream inputStream, long contentLength, String bucketName) {

    }

    @Override
    public void download(String bucketName, String key) {

    }

    @Override
    public void delete(String bucketName, String key) {

    }
}
