package com.tdrive.domain.storage.service;

import java.io.InputStream;

public interface StorageService {
    void upload(InputStream inputStream, long contentLength, String bucketName, String key);
    void download(String bucketName, String key);
    void delete(String bucketName, String key);
}
