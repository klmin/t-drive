package com.tdrive.api.v1.file.controller;

import com.tdrive.api.v1.file.converter.FileControllerConverter;
import com.tdrive.api.v1.file.request.FileUploadRequest;
import com.tdrive.api.v1.file.response.FileUploadResponse;
import com.tdrive.application.file.usecase.FileUploadUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/v1/resources/files")
@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileUploadUseCase fileUploadUseCase;
    private final FileControllerConverter converter;

    @PostMapping
    public ResponseEntity<FileUploadResponse> upload(@RequestPart("file") MultipartFile file,
                                                     @RequestPart("json") FileUploadRequest request) {
        var result = fileUploadUseCase.upload(converter.toDto(file, request));
        var response = converter.toResponse(result);
        return ResponseEntity.ok(response);
    }

}
