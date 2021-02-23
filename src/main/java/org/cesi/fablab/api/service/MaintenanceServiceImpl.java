package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.MaintenanceDTO;
import org.cesi.fablab.api.entity.MaintenanceEntity;
import org.cesi.fablab.api.entity.MaintenanceStatusEntity;
import org.cesi.fablab.api.entity.ResourceEntity;
import org.cesi.fablab.api.entity.TypeOperationEntity;
import org.cesi.fablab.api.entity.UserEntity;
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
    public final MaintenanceDTO addMaintenance(final MaintenanceDTO dto) throws Exception {
        // TODO Auto-generated method stub
        MaintenanceEntity entity = new MaintenanceEntity();
        entity.setNote(dto.getNote());
        entity.setSuccess(dto.isSuccess());
        entity.setDateEnd(dto.getDateEnd());
        entity.setDateStart(dto.getDateStart());
        ResourceEntity resource = new ResourceEntity();
        resource.setId(dto.getResource().getId());
        entity.setResource(resource);
        TypeOperationEntity typeOperation = new TypeOperationEntity();
        typeOperation.setId(dto.getType().getId());
        entity.setType(typeOperation);
        /*
         * UserEntity user = new UserEntity(); user.setId(dto.getUser().getId());
         * entity.setUser(user);
         */
        UserEntity user = new UserEntity();
        user.setId(1);
        entity.setUser(user);
        MaintenanceStatusEntity status = new MaintenanceStatusEntity();
        status.setId(dto.getStatus().getId());
        entity.setStatus(status);
        maintenanceRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removeMaintenance(final long id) throws Exception {
        // TODO Auto-generated method stub
        MaintenanceEntity entity = maintenanceRepository.findById(id);
        if (entity != null) {
            maintenanceRepository.delete(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final MaintenanceDTO updateMaintenance(final MaintenanceDTO dto) throws Exception {
        // TODO Auto-generated method stub
        MaintenanceEntity entity = maintenanceRepository.findById(dto.getId());
        entity.setNote(dto.getNote());
        entity.setSuccess(dto.isSuccess());
        entity.setDateEnd(dto.getDateEnd());
        entity.setDateStart(dto.getDateStart());
        ResourceEntity resource = new ResourceEntity();
        resource.setId(dto.getResource().getId());
        entity.setResource(resource);
        TypeOperationEntity typeOperation = new TypeOperationEntity();
        typeOperation.setId(dto.getType().getId());
        entity.setType(typeOperation);
        /*
         * UserEntity user = new UserEntity(); user.setId(dto.getUser().getId());
         * entity.setUser(user);
         */
        UserEntity user = new UserEntity();
        user.setId(1);
        entity.setUser(user);
        MaintenanceStatusEntity status = new MaintenanceStatusEntity();
        status.setId(dto.getStatus().getId());
        entity.setStatus(status);
        return new MaintenanceDTO(maintenanceRepository.save(entity));
    }

    @Override
    public final MaintenanceDTO getMaintenanceById(final long id) throws Exception {
        // TODO Auto-generated method stub
        return new MaintenanceDTO(maintenanceRepository.getOne(id));
    }

    @Override
    public final List<MaintenanceDTO> getMaintenancesByResource(final long idResource) throws Exception {
        // TODO Auto-generated method stub
        List<MaintenanceDTO> lstMaintenancesDTO = new ArrayList<MaintenanceDTO>();
        List<MaintenanceEntity> lstMaintenancesEntity = maintenanceRepository.findByResourceId(idResource);
        if (lstMaintenancesEntity != null && !lstMaintenancesEntity.isEmpty()) {
            for (MaintenanceEntity currentMaintenanceEntity : lstMaintenancesEntity) {
                MaintenanceDTO maintenanceDTO = new MaintenanceDTO(currentMaintenanceEntity);
                lstMaintenancesDTO.add(maintenanceDTO);
            }
        }
        return lstMaintenancesDTO;
    }

}
