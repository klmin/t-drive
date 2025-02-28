package com.tdrive.api.v1.file.request;

public record FileUploadRequest(
        Integer userSeq,
        Long parentFolderSeq
) {
}
