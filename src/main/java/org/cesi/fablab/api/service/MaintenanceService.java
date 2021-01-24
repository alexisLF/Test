package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.MaintenanceDTO;
import org.cesi.fablab.api.entity.MaintenanceEntity;

public interface MaintenanceService {
    List<MaintenanceDTO> getAllMaintenances() throws Exception;

    MaintenanceDTO addMaintenance(MaintenanceDTO dto) throws Exception;

    boolean removeMaintenance(MaintenanceDTO dto) throws Exception;

    MaintenanceEntity updateMaintenance(MaintenanceDTO dto) throws Exception;

    List<MaintenanceDTO> getMaintenancesByResource(long idResource) throws Exception;

    MaintenanceEntity getMaintenanceById(long id) throws Exception;

}
