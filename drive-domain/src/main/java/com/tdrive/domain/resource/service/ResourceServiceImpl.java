package com.tdrive.domain.resource.service;

import com.tdrive.domain.resource.model.Resource;
import com.tdrive.domain.resource.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    @Override
    public Resource insert(Resource resource) {
        System.out.println("call FileServiceImpl upload");
        Resource insertResource = resourceRepository.insert(resource);
        System.out.println("resource : "+resource);
        insertResource.initResourceSaveName();
        return resourceRepository.updateResourceName(insertResource);
    }

}
