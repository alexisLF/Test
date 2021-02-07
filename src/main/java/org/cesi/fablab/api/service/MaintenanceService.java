package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.MaintenanceDTO;

public interface MaintenanceService {
    List<MaintenanceDTO> getAllMaintenances() throws Exception;

    MaintenanceDTO addMaintenance(MaintenanceDTO dto) throws Exception;

    boolean removeMaintenance(long id) throws Exception;

    MaintenanceDTO updateMaintenance(MaintenanceDTO dto) throws Exception;

    List<MaintenanceDTO> getMaintenancesByResource(long idResource) throws Exception;

    MaintenanceDTO getMaintenanceById(long id) throws Exception;

}
