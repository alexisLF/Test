package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.ResourceStateDTO;
import org.cesi.fablab.api.entity.ResourceStateEntity;

public interface ResourceStateService {
    List<ResourceStateDTO> getAllResourceState() throws Exception;

    ResourceStateDTO addResourceState(ResourceStateDTO dto) throws Exception;

    boolean removeResourceState(long id) throws Exception;

    ResourceStateEntity updateResourceState(ResourceStateDTO dto) throws Exception;

    ResourceStateEntity getResourceStateById(long id) throws Exception;
}
