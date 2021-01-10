package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.MaintenanceDTO;
import org.cesi.fablab.api.entity.MaintenanceEntity;
import org.cesi.fablab.api.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {
	@Autowired
	private MaintenanceRepository maintenanceRepository;

	@Override
	public List<MaintenanceDTO> getAllMaintenances() throws Exception {
		List<MaintenanceDTO> lstMaintenancesDTO = new ArrayList<MaintenanceDTO>();
		List<MaintenanceEntity> lstMaintenancesEntity = maintenanceRepository.findAll();
		if (lstMaintenancesEntity != null && !lstMaintenancesEntity.isEmpty()) {
			for (MaintenanceEntity currentMaintenanceEntity : lstMaintenancesEntity) {
				MaintenanceDTO maintenanceDTO = new MaintenanceDTO(currentMaintenanceEntity);
				lstMaintenancesDTO.add(maintenanceDTO);
			}
		}
		return lstMaintenancesDTO;
	}

	@Override
	public final void addMaintenance(final MaintenanceDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public final void removeMaintenance(final MaintenanceDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public final void updateMaintenance(final MaintenanceDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

}
