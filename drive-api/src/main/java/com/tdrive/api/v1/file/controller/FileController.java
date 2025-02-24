package com.tdrive.api.v1.file.controller;

import com.tdrive.api.v1.file.request.FileUploadRequest;

import com.tdrive.application.file.usecase.FileUploadUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/files")
@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileUploadUseCase fileUploadUseCase;

    @PostMapping
    public ResponseEntity<String> upload(@RequestBody FileUploadRequest request) {
        fileUploadUseCase.upload();
        return ResponseEntity.ok("success");
    }

}
