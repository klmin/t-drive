package com.tdrive.api.v1.file.request;

import org.springframework.web.multipart.MultipartFile;

public record FileUploadRequest(
        Integer userSeq,
        Long parentFolderSeq,
        MultipartFile file
) {
}
