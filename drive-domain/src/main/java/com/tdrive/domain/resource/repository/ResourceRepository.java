package com.tdrive.domain.resource.repository;

import com.tdrive.domain.resource.model.Resource;

public interface ResourceRepository {

    Resource insert(Resource resource);
    Resource updateResourceName(Resource resource);
}
