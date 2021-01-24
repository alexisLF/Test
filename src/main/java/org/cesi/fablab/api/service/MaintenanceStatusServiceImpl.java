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
    public final MaintenanceStatusDTO addMaintenanceStatus(final MaintenanceStatusDTO dto) throws Exception {
        // TODO Auto-generated method stub
        MaintenanceStatusEntity entity = new MaintenanceStatusEntity();
        entity.setName(dto.getName());
        maintenanceStatusRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removeMaintenanceStatus(final long id) throws Exception {
        // TODO Auto-generated method stub

        MaintenanceStatusEntity entity = maintenanceStatusRepository.findById(id);
        if (entity != null) {
            maintenanceStatusRepository.delete(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final MaintenanceStatusEntity updateMaintenanceStatus(final MaintenanceStatusDTO dto) throws Exception {
        // TODO Auto-generated method stub
        MaintenanceStatusEntity entity = this.getMaintenanceStatusById(dto.getId());
        entity.setName(dto.getName());
        return maintenanceStatusRepository.save(entity);
    }

    @Override
    public final MaintenanceStatusEntity getMaintenanceStatusById(final long id) throws Exception {
        // TODO Auto-generated method stub
        return maintenanceStatusRepository.getOne(id);
    }

    @Override
    public final List<MaintenanceStatusDTO> getMaintenanceStatusByName(final String name) throws Exception {
        // TODO Auto-generated method stub
        List<MaintenanceStatusDTO> lstMaintenanceStatusDTO = new ArrayList<MaintenanceStatusDTO>();
        List<MaintenanceStatusEntity> lstMaintenanceStatusEntity = maintenanceStatusRepository.findByName(name);
        if (lstMaintenanceStatusEntity != null && !lstMaintenanceStatusEntity.isEmpty()) {
            for (MaintenanceStatusEntity currentMaintenanceStatusEntity : lstMaintenanceStatusEntity) {
                MaintenanceStatusDTO maintenanceStatusDTO = new MaintenanceStatusDTO(currentMaintenanceStatusEntity);
                lstMaintenanceStatusDTO.add(maintenanceStatusDTO);
            }
        }
        return lstMaintenanceStatusDTO;
    }

}
