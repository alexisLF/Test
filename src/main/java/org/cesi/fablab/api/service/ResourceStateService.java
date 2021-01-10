package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.ResourceStateDTO;

public interface ResourceStateService {
    List<ResourceStateDTO> getAllResourceStates() throws Exception;

    void addResourceState(ResourceStateDTO dto) throws Exception;

    void removeResourceState(ResourceStateDTO dto) throws Exception;

    void updateResourceState(ResourceStateDTO dto) throws Exception;

}
