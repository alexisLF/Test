package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.MaintenanceStatusDTO;

public interface MaintenanceStatusService {
    List<MaintenanceStatusDTO> getAllMaintenanceStatus() throws Exception;

    void addMaintenanceStatus(MaintenanceStatusDTO dto) throws Exception;

    void removeMaintenanceStatus(MaintenanceStatusDTO dto) throws Exception;

    void updateMaintenanceStatus(MaintenanceStatusDTO dto) throws Exception;

}
