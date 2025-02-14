package com.tdrive.driveinfra.persistence.file;

import com.tdrive.drivedomain.file.repository.FileRepository;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepositoryImpl implements FileRepository {

    @Override
    public String insert() {
        System.out.println("call FileRepositoryImpl insert");
        return "";
    }
}
