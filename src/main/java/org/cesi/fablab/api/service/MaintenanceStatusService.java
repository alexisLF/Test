package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.MaintenanceStatusDTO;

public interface MaintenanceStatusService {
    List<MaintenanceStatusDTO> getAllMaintenanceStatus() throws Exception;

    MaintenanceStatusDTO addMaintenanceStatus(MaintenanceStatusDTO dto) throws Exception;

    boolean removeMaintenanceStatus(long id) throws Exception;

    MaintenanceStatusDTO updateMaintenanceStatus(MaintenanceStatusDTO dto) throws Exception;

    MaintenanceStatusDTO getMaintenanceStatusById(long id) throws Exception;

    List<MaintenanceStatusDTO> getMaintenanceStatusByName(String name) throws Exception;

}
