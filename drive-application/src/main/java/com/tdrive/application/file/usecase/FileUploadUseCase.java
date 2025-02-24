package com.tdrive.application.file.usecase;

import com.tdrive.domain.file.service.FileService;
import com.tdrive.domain.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileUploadUseCase {

    private final FileService fileService;
    private final StorageService storageService;

    public String upload(){

        System.out.println("call FileUploadUseCase upload");

        // 1. DB 입력

        // 2. key 생성

        // 3. ceph 전송

        // 4. ceph 결과에 따라 db 삭제?

        fileService.insert();
        storageService.upload(null, 0, "test", "aa");
        return "";
    }
}
