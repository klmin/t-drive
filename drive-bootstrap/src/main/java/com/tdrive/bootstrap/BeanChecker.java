package com.tdrive.bootstrap;



import com.tdrive.api.v1.file.converter.FileControllerConverter;
import com.tdrive.api.v1.file.request.FileUploadRequest;
import com.tdrive.application.file.dto.FileUploadDto;
import com.tdrive.application.file.usecase.FileUploadUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

        FileUploadRequest request = new FileUploadRequest(1, 3L);
        FileUploadRequest request2 = new FileUploadRequest(2, 3L);

        ClassPathResource resource = new ClassPathResource("/test/test.txt");
        File file = resource.getFile();
        byte[] fileBytes = Files.readAllBytes(file.toPath());
        MultipartFile multipartFile = new CustomMultipartFile("file", file.getName(), "text/plain", fileBytes);
        FileUploadDto dto = converter.toDto(multipartFile, request);
        FileUploadDto dto2 = converter.toDto(multipartFile, request2);
        fileUploadUseCase.upload(dto);
        fileUploadUseCase.upload(dto2);

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
//        System.out.println("========== 등록된 StorageService 빈 ==========");
//        String[] storageBeans = context.getBeanNamesForType(StorageService.class);
//        for (String bean : storageBeans) {
//            System.out.println("등록된 빈: " + bean);
//        }
    }
}
