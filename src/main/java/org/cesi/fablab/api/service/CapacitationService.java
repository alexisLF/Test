package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.CapacitationDTO;

public interface CapacitationService {
	List<CapacitationDTO> getAllCapacitations() throws Exception;

	void addCapacitation(CapacitationDTO dto) throws Exception;

	void removeCapacitation(CapacitationDTO dto) throws Exception;

	void updateCapacitation(CapacitationDTO dto) throws Exception;

}
