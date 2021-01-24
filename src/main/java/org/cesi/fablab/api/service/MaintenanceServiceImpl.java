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
                ResourceEntity resource = new ResourceEntity();
                resource.setId(maintenanceDTO.getResource().getId());
                maintenanceDTO.setResource(resource);
                TypeOperationEntity typeOperation = new TypeOperationEntity();
                typeOperation.setId(maintenanceDTO.getType().getId());
                maintenanceDTO.setType(typeOperation);
                UserEntity user = new UserEntity();
                user.setId(maintenanceDTO.getUser().getId());
                maintenanceDTO.setUser(user);
                MaintenanceStatusEntity status = new MaintenanceStatusEntity();
                status.setId(maintenanceDTO.getStatus().getId());
                maintenanceDTO.setStatus(status);
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
        UserEntity user = new UserEntity();
        user.setId(dto.getUser().getId());
        entity.setUser(user);
        MaintenanceStatusEntity status = new MaintenanceStatusEntity();
        status.setId(dto.getStatus().getId());
        entity.setStatus(status);
        maintenanceRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removeMaintenance(final MaintenanceDTO dto) throws Exception {
        // TODO Auto-generated method stub

        MaintenanceEntity entity = maintenanceRepository.findById(dto.getId());
        if (entity != null) {
            maintenanceRepository.delete(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final MaintenanceEntity updateMaintenance(final MaintenanceDTO dto) throws Exception {
        // TODO Auto-generated method stub

        MaintenanceEntity entity = this.getMaintenanceById(dto.getId());
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
        UserEntity user = new UserEntity();
        user.setId(dto.getUser().getId());
        entity.setUser(user);
        MaintenanceStatusEntity status = new MaintenanceStatusEntity();
        status.setId(dto.getStatus().getId());
        entity.setStatus(status);
        return maintenanceRepository.save(entity);
    }

    @Override
    public final MaintenanceEntity getMaintenanceById(final long id) throws Exception {
        // TODO Auto-generated method stub

        MaintenanceEntity maintenanceEntity = maintenanceRepository.getOne(id);
        ResourceEntity resource = new ResourceEntity();
        resource.setId(maintenanceEntity.getResource().getId());
        maintenanceEntity.setResource(resource);
        TypeOperationEntity typeOperation = new TypeOperationEntity();
        typeOperation.setId(maintenanceEntity.getType().getId());
        maintenanceEntity.setType(typeOperation);
        UserEntity user = new UserEntity();
        user.setId(maintenanceEntity.getUser().getId());
        maintenanceEntity.setUser(user);
        MaintenanceStatusEntity status = new MaintenanceStatusEntity();
        status.setId(maintenanceEntity.getStatus().getId());
        maintenanceEntity.setStatus(status);
        return maintenanceEntity;
    }

    @Override
    public final List<MaintenanceDTO> getMaintenancesByResource(final long idResource) throws Exception {
        // TODO Auto-generated method stub
        List<MaintenanceDTO> lstMaintenancesDTO = new ArrayList<MaintenanceDTO>();
        List<MaintenanceEntity> lstMaintenancesEntity = maintenanceRepository.findByResourceId(idResource);
        if (lstMaintenancesEntity != null && !lstMaintenancesEntity.isEmpty()) {
            for (MaintenanceEntity currentMaintenanceEntity : lstMaintenancesEntity) {
                MaintenanceDTO maintenanceDTO = new MaintenanceDTO(currentMaintenanceEntity);
                ResourceEntity resource = new ResourceEntity();
                resource.setId(maintenanceDTO.getResource().getId());
                maintenanceDTO.setResource(resource);
                TypeOperationEntity typeOperation = new TypeOperationEntity();
                typeOperation.setId(maintenanceDTO.getType().getId());
                maintenanceDTO.setType(typeOperation);
                UserEntity user = new UserEntity();
                user.setId(maintenanceDTO.getUser().getId());
                maintenanceDTO.setUser(user);
                MaintenanceStatusEntity status = new MaintenanceStatusEntity();
                status.setId(maintenanceDTO.getStatus().getId());
                maintenanceDTO.setStatus(status);
                lstMaintenancesDTO.add(maintenanceDTO);
            }
        }
        return lstMaintenancesDTO;
    }

}
