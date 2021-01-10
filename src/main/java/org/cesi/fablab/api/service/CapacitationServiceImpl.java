package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.CapacitationDTO;
import org.cesi.fablab.api.entity.CapacitationEntity;
import org.cesi.fablab.api.repository.CapacitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapacitationServiceImpl implements CapacitationService {
	@Autowired
	private CapacitationRepository capacitationRepository;

	@Override
	public List<CapacitationDTO> getAllCapacitations() throws Exception {
		List<CapacitationDTO> lstCapacitationsDTO = new ArrayList<CapacitationDTO>();
		List<CapacitationEntity> lstCapacitationsEntity = capacitationRepository.findAll();
		if (lstCapacitationsEntity != null && !lstCapacitationsEntity.isEmpty()) {
			for (CapacitationEntity currentCapacitationEntity : lstCapacitationsEntity) {
				CapacitationDTO capacitationDTO = new CapacitationDTO(currentCapacitationEntity);
				lstCapacitationsDTO.add(capacitationDTO);
			}
		}
		return lstCapacitationsDTO;
	}

	@Override
	public final void addCapacitation(final CapacitationDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public final void removeCapacitation(final CapacitationDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public final void updateCapacitation(final CapacitationDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

}
