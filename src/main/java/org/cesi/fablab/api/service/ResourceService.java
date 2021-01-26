package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.ResourceDTO;
import org.cesi.fablab.api.entity.ResourceEntity;

public interface ResourceService {
    List<ResourceDTO> getAllResources() throws Exception;

    ResourceDTO addResource(ResourceDTO dto) throws Exception;

    boolean removeResource(long id) throws Exception;

    ResourceEntity updateResource(ResourceDTO dto) throws Exception;

    ResourceEntity getResourceById(long id) throws Exception;

    List<ResourceDTO> getResourcesByStateId(long idState) throws Exception;
}
