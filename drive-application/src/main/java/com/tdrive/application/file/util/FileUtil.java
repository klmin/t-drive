package com.tdrive.application.file.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtil {

    public static FileExtractResultDto extract(MultipartFile file) {
        System.out.println("extract######");
        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        String ext = getFileExtension(originalFilename);

        try{
            return new FileExtractResultDto(originalFilename, ext, file.getContentType(), file.getSize(), file.getBytes());
        }catch(IOException e){
            throw new RuntimeException("파일 추출중 오류가 발생하였습니다.");
        }
    }

    private static String getFileExtension(String filename) {
        return filename.contains(".") ? filename.substring(filename.lastIndexOf(".") + 1) : "";
    }

}
