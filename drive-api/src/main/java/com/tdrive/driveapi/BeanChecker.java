package com.tdrive.driveapi;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeanChecker implements ApplicationRunner {

    private final ApplicationContext context;
//    private final StorageService storageService;

    @Override
    public void run(ApplicationArguments args) {
//        System.out.println("storageService name : "+storageService.getClass().getName());
//        storageService.get();
//        System.out.println("========== 등록된 StorageService 빈 ==========");
//        String[] storageBeans = context.getBeanNamesForType(StorageService.class);
//        for (String bean : storageBeans) {
//            System.out.println("등록된 빈: " + bean);
//        }
    }
}
