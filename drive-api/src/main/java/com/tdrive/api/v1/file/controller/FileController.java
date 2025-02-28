package com.tdrive.api.v1.file.controller;

import com.tdrive.api.v1.file.converter.FileControllerConverter;
import com.tdrive.api.v1.file.request.FileUploadRequest;
import com.tdrive.api.v1.file.response.FileUploadResponse;
import com.tdrive.application.file.usecase.FileUploadUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/files")
@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileUploadUseCase fileUploadUseCase;
    private final FileControllerConverter converter;

    @PostMapping
    public ResponseEntity<FileUploadResponse> upload(@RequestBody FileUploadRequest request) {
        var result = fileUploadUseCase.upload(converter.toDto(request));
        var response = converter.toResponse(result);
        return ResponseEntity.ok(response);
    }

}
