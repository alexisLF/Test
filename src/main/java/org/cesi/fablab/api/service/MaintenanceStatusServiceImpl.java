package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.MaintenanceStatusDTO;
import org.cesi.fablab.api.entity.MaintenanceStatusEntity;
import org.cesi.fablab.api.repository.MaintenanceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceStatusServiceImpl implements MaintenanceStatusService {
	@Autowired
	private MaintenanceStatusRepository maintenanceStatusRepository;

	@Override
	public List<MaintenanceStatusDTO> getAllMaintenanceStatus() throws Exception {
		List<MaintenanceStatusDTO> lstMaintenanceStatusDTO = new ArrayList<MaintenanceStatusDTO>();
		List<MaintenanceStatusEntity> lstMaintenanceStatusEntity = maintenanceStatusRepository.findAll();
		if (lstMaintenanceStatusEntity != null && !lstMaintenanceStatusEntity.isEmpty()) {
			for (MaintenanceStatusEntity currentMaintenanceStatusEntity : lstMaintenanceStatusEntity) {
				MaintenanceStatusDTO maintenanceStatusDTO = new MaintenanceStatusDTO(currentMaintenanceStatusEntity);
				lstMaintenanceStatusDTO.add(maintenanceStatusDTO);
			}
		}
		return lstMaintenanceStatusDTO;
	}

	@Override
	public final void addMaintenanceStatus(final MaintenanceStatusDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public final void removeMaintenanceStatus(final MaintenanceStatusDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public final void updateMaintenanceStatus(final MaintenanceStatusDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

}
