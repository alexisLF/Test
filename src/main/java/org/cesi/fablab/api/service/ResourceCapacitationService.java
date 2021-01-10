package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.ResourceCapacitationDTO;

public interface ResourceCapacitationService {
    List<ResourceCapacitationDTO> getAllResourceCapacitations() throws Exception;

    void addResourceCapacitation(ResourceCapacitationDTO dto) throws Exception;

    void removeResourceCapacitation(ResourceCapacitationDTO dto) throws Exception;

    void updateResourceCapacitation(ResourceCapacitationDTO dto) throws Exception;

}
