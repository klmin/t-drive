package com.tdrive.infra.persistence.jpa.resource.repository;


import com.tdrive.domain.resource.model.Resource;
import com.tdrive.domain.resource.repository.ResourceRepository;
import com.tdrive.infra.persistence.jpa.resource.entity.ResourceEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceRepositoryImpl implements ResourceRepository {

    @Override
    public int insert(Resource resource) {
        System.out.println("call Jpa FileRepositoryImpl insert");
        return 0;
    }
}
