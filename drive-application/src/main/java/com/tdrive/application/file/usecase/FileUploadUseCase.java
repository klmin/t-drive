package com.tdrive.application.file.usecase;

import com.tdrive.application.file.converter.FileApplicationConverter;
import com.tdrive.application.file.dto.FileUploadDto;
import com.tdrive.application.file.dto.FileUploadResponseDto;
import com.tdrive.domain.resource.model.Resource;
import com.tdrive.domain.resource.service.ResourceService;
import com.tdrive.domain.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileUploadUseCase {

    private final ResourceService resourceService;
    private final StorageService storageService;
    private final FileApplicationConverter converter;

    public FileUploadResponseDto upload(FileUploadDto dto){

        System.out.println("call FileUploadUseCase upload");

        // 1. DB 입력

        // 2. key 생성

        // 3. ceph 전송

        // 4. ceph 결과에 따라 db 삭제?

        // 5. ceph 실패시 db 삭제

        // path = parentfolder
        // register_user_seq
        // user_seq

        Resource resource = resourceService.insert(converter.toResource(dto));
        System.out.println("resource : "+resource);

        storageService.upload(null, 0, "test", "user/test1");

        var response = FileUploadResponseDto.builder().build();

        return response;
    }
}
