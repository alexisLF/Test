package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.ResourceCapacitationDTO;
import org.cesi.fablab.api.entity.ResourceCapacitationEntity;
import org.cesi.fablab.api.repository.ResourceCapacitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceCapacitationServiceImpl implements ResourceCapacitationService {
    @Autowired
    private ResourceCapacitationRepository resourceCapacitationRepository;

    @Override
    public List<ResourceCapacitationDTO> getAllResourceCapacitation() throws Exception {
        List<ResourceCapacitationDTO> lstResourceCapacitationDTO = new ArrayList<ResourceCapacitationDTO>();
        List<ResourceCapacitationEntity> lstResourceCapacitationEntity = resourceCapacitationRepository.findAll();
        if (lstResourceCapacitationEntity != null && !lstResourceCapacitationEntity.isEmpty()) {
            for (ResourceCapacitationEntity currentResourceCapacitationEntity : lstResourceCapacitationEntity) {
                ResourceCapacitationDTO resourceCapacitationDTO = new ResourceCapacitationDTO(
                        currentResourceCapacitationEntity);
                lstResourceCapacitationDTO.add(resourceCapacitationDTO);
            }
        }
        return lstResourceCapacitationDTO;
    }

    @Override
    public final ResourceCapacitationDTO addResourceCapacitation(final ResourceCapacitationDTO dto) throws Exception {
        // TODO Auto-generated method stub
        ResourceCapacitationEntity entity = new ResourceCapacitationEntity();
        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        resourceCapacitationRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removeResourceCapacitation(final long id) throws Exception {
        // TODO Auto-generated method stub

        ResourceCapacitationEntity entity = resourceCapacitationRepository.findById(id);
        if (entity != null) {
            resourceCapacitationRepository.delete(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final ResourceCapacitationDTO updateResourceCapacitation(final ResourceCapacitationDTO dto)
            throws Exception {
        // TODO Auto-generated method stub
        ResourceCapacitationEntity entity = resourceCapacitationRepository.getOne(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        return new ResourceCapacitationDTO(resourceCapacitationRepository.save(entity));
    }

    @Override
    public final ResourceCapacitationDTO getResourceCapacitationById(final long id) throws Exception {
        // TODO Auto-generated method stub
        return new ResourceCapacitationDTO(resourceCapacitationRepository.getOne(id));
    }

}
