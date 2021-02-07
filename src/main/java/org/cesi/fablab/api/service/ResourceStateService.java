package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.ResourceStateDTO;

public interface ResourceStateService {
    List<ResourceStateDTO> getAllResourceState() throws Exception;

    ResourceStateDTO addResourceState(ResourceStateDTO dto) throws Exception;

    boolean removeResourceState(long id) throws Exception;

    ResourceStateDTO updateResourceState(ResourceStateDTO dto) throws Exception;

    ResourceStateDTO getResourceStateById(long id) throws Exception;
}
