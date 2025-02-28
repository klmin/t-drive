package com.tdrive.application.file.usecase;

import com.tdrive.application.file.converter.FileApplicationConverter;
import com.tdrive.application.file.dto.FileUploadDto;
import com.tdrive.application.file.dto.FileUploadResponseDto;
import com.tdrive.domain.resource.service.ResourceService;
import com.tdrive.domain.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class FileUploadUseCase {

    private final ResourceService resourceService;
    private final StorageService storageService;
    private final FileApplicationConverter converter;

    @Transactional
    public FileUploadResponseDto upload(FileUploadDto dto){

        System.out.println("call FileUploadUseCase upload");



        // 1. 파일분해

        // 2. DB 입력

        // 3. key 생성

        // 4. ceph 전송

        // 5. ceph 실패시 db 삭제

        // path = parentfolder
        // register_user_seq
        // user_seq

        resourceService.insert(converter.toResource(dto));
        storageService.upload(null, 0, "test", "user/test1");

        var response = FileUploadResponseDto.builder().build();

        return response;
    }
}
