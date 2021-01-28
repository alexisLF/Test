package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.ResourceDTO;
import org.cesi.fablab.api.entity.CapacitationEntity;
import org.cesi.fablab.api.entity.DocumentationEntity;
import org.cesi.fablab.api.entity.MaintenanceEntity;
import org.cesi.fablab.api.entity.ReservationEntity;
import org.cesi.fablab.api.entity.ResourceEntity;
import org.cesi.fablab.api.entity.ResourceStateEntity;
import org.cesi.fablab.api.entity.RoomEntity;
import org.cesi.fablab.api.entity.SecurityGearEntity;
import org.cesi.fablab.api.entity.TypeResourceEntity;
import org.cesi.fablab.api.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public List<ResourceDTO> getAllResources() throws Exception {
        List<ResourceDTO> lstResourceDTO = new ArrayList<ResourceDTO>();
        List<ResourceEntity> lstResourceEntity = resourceRepository.findAll();
        if (lstResourceEntity != null && !lstResourceEntity.isEmpty()) {
            for (ResourceEntity currentResourceEntity : lstResourceEntity) {
                ResourceDTO resourceDTO = new ResourceDTO(currentResourceEntity);
                lstResourceDTO.add(resourceDTO);
            }
        }
        return lstResourceDTO;
    }

    @Override
    public final ResourceDTO addResource(final ResourceDTO dto) throws Exception {
        // TODO Auto-generated method stub
        ResourceEntity entity = new ResourceEntity();
        entity.setRef(dto.getRef());
        entity.setName(dto.getName());
        entity.setDateInstallation(dto.getDateInstallation());
        entity.setStock(dto.getStock());
        entity.setIsActive(dto.getIsActive());
        TypeResourceEntity type = new TypeResourceEntity();
        type.setId(dto.getType().getId());
        entity.setType(type);
        RoomEntity room = new RoomEntity();
        room.setId(dto.getRoom().getId());
        entity.setRoom(room);
        ResourceStateEntity state = new ResourceStateEntity();
        state.setId(dto.getState().getId());
        entity.setState(state);
        DocumentationEntity documentation = new DocumentationEntity();
        documentation.setId(dto.getDocumentation().getId());
        entity.setDocumentation(documentation);
        List<SecurityGearEntity> securityList = new ArrayList<SecurityGearEntity>();
        for (SecurityGearEntity securityGear : dto.getSecuritysList()) {
            securityList.add(securityGear);
        }
        entity.setSecuritysList(securityList);
        List<ReservationEntity> reservationList = new ArrayList<ReservationEntity>();
        for (ReservationEntity reservation : dto.getReservationsList()) {
            reservationList.add(reservation);
        }
        entity.setReservationsList(reservationList);
        List<MaintenanceEntity> maintenanceList = new ArrayList<MaintenanceEntity>();
        for (MaintenanceEntity maintenance : dto.getMaintenancesList()) {
            maintenanceList.add(maintenance);
        }
        entity.setMaintenancesList(maintenanceList);
        List<ResourceEntity> consumableList = new ArrayList<ResourceEntity>();
        for (ResourceEntity consumable : dto.getConsumableResources()) {
            consumableList.add(consumable);
        }
        entity.setConsumableResources(consumableList);
        List<CapacitationEntity> capacitationList = new ArrayList<CapacitationEntity>();
        for (CapacitationEntity capacitation : dto.getResourceCapacitationList()) {
            capacitationList.add(capacitation);
        }
        entity.setResourceCapacitationList(capacitationList);
        resourceRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removeResource(final long id) throws Exception {
        // TODO Auto-generated method stub

        ResourceEntity entity = resourceRepository.findById(id);
        if (entity != null) {
            resourceRepository.delete(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final ResourceEntity updateResource(final ResourceDTO dto) throws Exception {
        // TODO Auto-generated method stub
        ResourceEntity entity = this.getResourceById(dto.getId());
        entity.setRef(dto.getRef());
        entity.setName(dto.getName());
        entity.setDateInstallation(dto.getDateInstallation());
        entity.setStock(dto.getStock());
        entity.setIsActive(dto.getIsActive());
        TypeResourceEntity type = new TypeResourceEntity();
        type.setId(dto.getType().getId());
        entity.setType(type);
        RoomEntity room = new RoomEntity();
        room.setId(dto.getRoom().getId());
        entity.setRoom(room);
        ResourceStateEntity state = new ResourceStateEntity();
        state.setId(dto.getState().getId());
        entity.setState(state);
        DocumentationEntity documentation = new DocumentationEntity();
        documentation.setId(dto.getDocumentation().getId());
        entity.setDocumentation(documentation);
        List<SecurityGearEntity> securityList = new ArrayList<SecurityGearEntity>();
        for (SecurityGearEntity securityGear : dto.getSecuritysList()) {
            securityList.add(securityGear);
        }
        entity.setSecuritysList(securityList);
        List<ReservationEntity> reservationList = new ArrayList<ReservationEntity>();
        for (ReservationEntity reservation : dto.getReservationsList()) {
            reservationList.add(reservation);
        }
        entity.setReservationsList(reservationList);
        List<MaintenanceEntity> maintenanceList = new ArrayList<MaintenanceEntity>();
        for (MaintenanceEntity maintenance : dto.getMaintenancesList()) {
            maintenanceList.add(maintenance);
        }
        entity.setMaintenancesList(maintenanceList);
        List<ResourceEntity> consumableList = new ArrayList<ResourceEntity>();
        for (ResourceEntity consumable : dto.getConsumableResources()) {
            consumableList.add(consumable);
        }
        entity.setConsumableResources(consumableList);
        List<CapacitationEntity> capacitationList = new ArrayList<CapacitationEntity>();
        for (CapacitationEntity capacitation : dto.getResourceCapacitationList()) {
            capacitationList.add(capacitation);
        }
        entity.setResourceCapacitationList(capacitationList);
        return resourceRepository.save(entity);
    }

    @Override
    public final ResourceEntity getResourceById(final long id) throws Exception {
        // TODO Auto-generated method stub
        ResourceEntity entity = resourceRepository.getOne(id);
        return entity;
    }

    @Override
    public List<ResourceDTO> getResourcesByStateId(long idState) throws Exception {
        List<ResourceDTO> lstResourceDTO = new ArrayList<ResourceDTO>();
        List<ResourceEntity> lstResourceEntity = resourceRepository.findByStateId(idState);
        if (lstResourceEntity != null && !lstResourceEntity.isEmpty()) {
            for (ResourceEntity currentResourceEntity : lstResourceEntity) {
                ResourceDTO resourceDTO = new ResourceDTO(currentResourceEntity);
                lstResourceDTO.add(resourceDTO);
            }
        }
        return lstResourceDTO;
    }

    @Override
    public List<ResourceDTO> getResourcesBySiteId(long idSite) throws Exception {
        List<ResourceDTO> lstResourceDTO = new ArrayList<ResourceDTO>();
        List<ResourceEntity> lstResourceEntity = resourceRepository.findByRoomSiteId(idSite);
        if (lstResourceEntity != null && !lstResourceEntity.isEmpty()) {
            for (ResourceEntity currentResourceEntity : lstResourceEntity) {
                ResourceDTO resourceDTO = new ResourceDTO(currentResourceEntity);
                lstResourceDTO.add(resourceDTO);
            }
        }
        return lstResourceDTO;
    }

}
