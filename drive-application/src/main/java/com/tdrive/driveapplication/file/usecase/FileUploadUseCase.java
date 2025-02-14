package com.tdrive.driveapplication.file.usecase;

import com.tdrive.drivedomain.file.service.FileService;
import com.tdrive.drivedomain.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileUploadUseCase {

    private final FileService fileService;
    private final StorageService storageService;

    public String upload(){
        System.out.println("call FileUploadUseCase upload");
        fileService.upload();
        storageService.get();
        return "";
    }
}
