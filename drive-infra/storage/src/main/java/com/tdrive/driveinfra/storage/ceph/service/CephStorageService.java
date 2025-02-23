package com.tdrive.driveinfra.storage.ceph.service;

import com.tdrive.drivedomain.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@ConditionalOnProperty(name = "storage.type", havingValue = "ceph", matchIfMissing = true)
@Service
@RequiredArgsConstructor
public class CephStorageService implements StorageService {

    private final S3Client s3Client;

    @Override
    public void upload(InputStream inputStream, long contentLength, String bucketName) {

        s3Client.createBucket(req -> {
            System.out.println("create");
            req.bucket(bucketName);
        });


        ByteBuffer input = ByteBuffer.wrap("Hello World!".getBytes());
        s3Client.putObject(
                req -> {
                    req.bucket(bucketName).key("hello.txt");
                },
                RequestBody.fromByteBuffer(input)
        );

        s3Client.putObject(
                req -> {
                    req.bucket(bucketName).key("aa/aa/hello.txt");
                },
                RequestBody.fromByteBuffer(input)
        );

        ListObjectsResponse loResponse = s3Client.listObjects(req -> {
            req.bucket(bucketName);
        });

        for (S3Object object : loResponse.contents()) {
            System.out.println(
                    object.key() + "\t" +
                            object.size() + "\t" +
                            object.lastModified()
            );
        }

        this.download("test", "hello.txt");
        this.delete("test", "hello.txt");

//        s3Client.createBucket(req -> {
//            System.out.println("create");
//            req.bucket(bucketName);
//        });
//
//        ListObjectsResponse loResponse = s3Client.listObjects(req -> {
//            req.bucket(bucketName);
//        });
//
//        for (S3Object object : loResponse.contents()) {
//            System.out.println(
//                    object.key() + "\t" +
//                            object.size() + "\t" +
//                            object.lastModified()
//            );
//        }
//
//        String key = generateKey();
//
//        System.out.println("call CephStorageService upload");
//        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
//                .bucket(bucketName)
//                .key(key)
//                .build();
//        s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(inputStream, contentLength));
//
//        System.out.println("File uploaded to Ceph: " + key);
    }

    @Override
    public void download(String bucketName, String key)  {
//        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
//                .bucket(bucketName)
//                .key(key)
//                .build();
//
//        try {
//            Files.copy(
//                    s3Client.getObject(getObjectRequest),
//                    Paths.get("C:\\ceph"),
//                    StandardCopyOption.REPLACE_EXISTING
//            );
//            System.out.println("File downloaded from Ceph: " + key);
//        } catch (Exception e) {
//            throw new RuntimeException("Error downloading file from Ceph", e);
//        }

        GetObjectRequest request = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        //ResponseInputStream<GetObjectResponse> response = s3Client.getObject(request);

        try {
            Files.copy(
                    s3Client.getObject(request),
                    Paths.get("C:/ceph/hello.txt"),
                    StandardCopyOption.REPLACE_EXISTING
            );
        }catch (IOException e) {
            e.printStackTrace();
        }

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            s3Client.getObject(request).transferTo(outputStream);
            System.out.println("ByteArrayResource : "+new ByteArrayResource(outputStream.toByteArray()));
        } catch (IOException e) {
            throw new RuntimeException("Error downloading file from Ceph", e);
        }


        HeadObjectRequest headObjectRequest = HeadObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        HeadObjectResponse headObjectResponse = s3Client.headObject(headObjectRequest);

        System.out.println("File Size: " + headObjectResponse.contentLength());
        System.out.println("Content Type: " + headObjectResponse.contentType());
        System.out.println("Last Modified: " + headObjectResponse.lastModified());

//         s3Client.getObject(
//                req -> {
//                    req.bucket(bucketName).key(key);
//                },
//                Paths.get("C:/ceph/hello.txt")
//        );
    }

    @Override
    public void delete(String bucketName, String key) {

        s3Client.deleteObject(req -> {
            req.bucket(bucketName).key(key);
        });

//        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
//                .bucket(bucketName)
//                .key(key)
//                .build();
//
//        s3Client.deleteObject(deleteObjectRequest);
//        System.out.println("File deleted from Ceph: " + key);
    }

    public String generateKey(){
        return "";
    }

    public void createBucketIfNotExists(String bucketName) {
        try {
            s3Client.createBucket(CreateBucketRequest.builder().bucket(bucketName).build());
        } catch (S3Exception e) {
            if (e.statusCode() != 409) { // 409 Conflict → 이미 존재
                throw e;
            }
        }
    }


}
