package com.tdrive.infra.persistence.file;

import com.tdrive.domain.file.repository.FileRepository;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepositoryImpl implements FileRepository {

    @Override
    public String insert() {
        System.out.println("call FileRepositoryImpl insert");
        return "";
    }
}
