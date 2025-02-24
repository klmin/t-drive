package com.tdrive.domain.file.service;

import com.tdrive.domain.file.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    @Override
    public String insert() {
        System.out.println("call FileServiceImpl upload");
        fileRepository.insert();
        return "";
    }
}
