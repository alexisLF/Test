package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.ResourceDTO;

public interface ResourceService {
    List<ResourceDTO> getAllResources() throws Exception;

    ResourceDTO addResource(ResourceDTO dto) throws Exception;

    boolean removeResource(long id) throws Exception;

    ResourceDTO updateResource(ResourceDTO dto) throws Exception;

    ResourceDTO getResourceById(long id) throws Exception;

    List<ResourceDTO> getResourcesByStateId(long idState) throws Exception;

    List<ResourceDTO> getResourcesBySiteId(long idState) throws Exception;
}
