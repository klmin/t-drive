package com.tdrive.bootstrap;


import com.tdrive.driveapplication.file.usecase.FileUploadUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeanChecker implements ApplicationRunner {

    private final ApplicationContext context;
    private final FileUploadUseCase fileUploadUseCase;

    @Override
    public void run(ApplicationArguments args) {
        fileUploadUseCase.upload();
//        System.out.println("========== 등록된 StorageService 빈 ==========");
//        String[] storageBeans = context.getBeanNamesForType(StorageService.class);
//        for (String bean : storageBeans) {
//            System.out.println("등록된 빈: " + bean);
//        }
    }
}
