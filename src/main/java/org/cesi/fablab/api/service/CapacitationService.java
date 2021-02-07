package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.CapacitationDTO;

public interface CapacitationService {
    List<CapacitationDTO> getAllCapacitation() throws Exception;

    CapacitationDTO addCapacitation(CapacitationDTO dto) throws Exception;

    boolean removeCapacitation(long id) throws Exception;

    CapacitationDTO updateCapacitation(CapacitationDTO dto) throws Exception;

    CapacitationDTO getCapacitationById(long id) throws Exception;

}
