package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.MaintenanceDTO;

public interface MaintenanceService {
	List<MaintenanceDTO> getAllMaintenances() throws Exception;

	void addMaintenance(MaintenanceDTO dto) throws Exception;

	void removeMaintenance(MaintenanceDTO dto) throws Exception;

	void updateMaintenance(MaintenanceDTO dto) throws Exception;

}
