package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.ResourceCapacitationDTO;

public interface ResourceCapacitationService {
    List<ResourceCapacitationDTO> getAllResourceCapacitation() throws Exception;

    ResourceCapacitationDTO addResourceCapacitation(ResourceCapacitationDTO dto) throws Exception;

    boolean removeResourceCapacitation(long id) throws Exception;

    ResourceCapacitationDTO updateResourceCapacitation(ResourceCapacitationDTO dto) throws Exception;

    ResourceCapacitationDTO getResourceCapacitationById(long id) throws Exception;

}
