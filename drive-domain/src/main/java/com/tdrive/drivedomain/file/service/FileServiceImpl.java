package com.tdrive.drivedomain.file.service;

import com.tdrive.drivedomain.file.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    @Override
    public String upload() {
        System.out.println("call FileServiceImpl upload");
        fileRepository.insert();
        return "";
    }
}
