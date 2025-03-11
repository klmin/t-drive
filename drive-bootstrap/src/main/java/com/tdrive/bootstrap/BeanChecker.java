package com.tdrive.bootstrap;


import com.tdrive.api.v1.file.converter.FileControllerConverter;
import com.tdrive.api.v1.file.request.FileUploadRequest;
import com.tdrive.application.file.dto.FileUploadDto;
import com.tdrive.application.file.usecase.FileUploadUseCase;
import com.tdrive.domain.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class BeanChecker implements ApplicationRunner {

    private final FileUploadUseCase fileUploadUseCase;
    private final DataSource dataSource;
    private final FileControllerConverter converter;

    @Override
    public void run(ApplicationArguments args) throws IOException {

//        ClassPathResource resource = new ClassPathResource("/test/test.txt");
//        File file = resource.getFile();
//        byte[] fileBytes = Files.readAllBytes(file.toPath());
//        MultipartFile multipartFile = new CustomMultipartFile("file", file.getName(), "text/plain", fileBytes);
//        FileUploadRequest request = new FileUploadRequest(1, 3L, multipartFile);
//        FileUploadRequest request2 = new FileUploadRequest(2, 3L, multipartFile);
//
//        FileUploadDto dto = converter.toDto(request);
//        FileUploadDto dto2 = converter.toDto(request2);
//        fileUploadUseCase.upload(dto);
//        fileUploadUseCase.upload(dto2);
//
        try(Connection connection = dataSource.getConnection()){
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("metaData.getConnection().getSchema() : " + metaData.getConnection().getSchema());
            System.out.println("metaData.getURL() : " + metaData.getURL());
            System.out.println("metaData.getDatabaseProductName() : " + metaData.getDatabaseProductName());
            System.out.println("metaData.getDatabaseProductVersion() : " + metaData.getDatabaseProductVersion());
            System.out.println("metaData.getDriverName() : " + metaData.getDriverName());
            System.out.println("metaData.getUserName() : " + metaData.getUserName());
        }catch(SQLException e){
            System.err.println("❌ Failed to get DataSource info: " + e.getMessage());
        }
        
        if (dataSource instanceof com.zaxxer.hikari.HikariDataSource) {
            System.out.println("Using HikariCP as DataSource");
        } else {
            System.out.println("Not using HikariCP");
        }
        
//        System.out.println("========== 등록된 StorageService 빈 ==========");
//        String[] storageBeans = context.getBeanNamesForType(StorageService.class);
//        for (String bean : storageBeans) {
//            System.out.println("등록된 빈: " + bean);
//        }
    }
}
