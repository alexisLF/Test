package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.ResourceCapacitationDTO;
import org.cesi.fablab.api.entity.ResourceCapacitationEntity;

public interface ResourceCapacitationService {
    List<ResourceCapacitationDTO> getAllResourceCapacitation() throws Exception;

    ResourceCapacitationDTO addResourceCapacitation(ResourceCapacitationDTO dto) throws Exception;

    boolean removeResourceCapacitation(long id) throws Exception;

    ResourceCapacitationEntity updateResourceCapacitation(ResourceCapacitationDTO dto) throws Exception;

    ResourceCapacitationEntity getResourceCapacitationById(long id) throws Exception;

}
