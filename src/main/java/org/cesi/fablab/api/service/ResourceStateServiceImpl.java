package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.ResourceStateDTO;
import org.cesi.fablab.api.entity.ResourceEntity;
import org.cesi.fablab.api.entity.ResourceStateEntity;
import org.cesi.fablab.api.repository.ResourceRepository;
import org.cesi.fablab.api.repository.ResourceStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceStateServiceImpl implements ResourceStateService {
    @Autowired
    private ResourceStateRepository resourceStateRepository;
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public List<ResourceStateDTO> getAllResourceState() throws Exception {
        List<ResourceStateDTO> lstResourceStateDTO = new ArrayList<ResourceStateDTO>();
        List<ResourceStateEntity> lstResourceStateEntity = resourceStateRepository.findAll();
        if (lstResourceStateEntity != null && !lstResourceStateEntity.isEmpty()) {
            for (ResourceStateEntity currentResourceStateEntity : lstResourceStateEntity) {
                ResourceStateDTO resourceStateDTO = new ResourceStateDTO(currentResourceStateEntity);
                lstResourceStateDTO.add(resourceStateDTO);
            }
        }
        return lstResourceStateDTO;
    }

    @Override
    public final ResourceStateDTO addResourceState(final ResourceStateDTO dto) throws Exception {
        // TODO Auto-generated method stub
        ResourceStateEntity entity = new ResourceStateEntity();
        entity.setName(dto.getName());
        resourceStateRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removeResourceState(final long id) throws Exception {
        // TODO Auto-generated method stub
        ResourceStateEntity entity = resourceStateRepository.findById(id);
        if (entity != null) {
            List<ResourceEntity> resourceList = resourceRepository.findByStateId(entity.getId());
            if (resourceList.isEmpty()) {
                resourceStateRepository.delete(entity);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public final ResourceStateDTO updateResourceState(final ResourceStateDTO dto) throws Exception {
        // TODO Auto-generated method stub
        ResourceStateEntity entity = resourceStateRepository.getOne(dto.getId());
        entity.setName(dto.getName());
        return new ResourceStateDTO(resourceStateRepository.save(entity));
    }

    @Override
    public final ResourceStateDTO getResourceStateById(final long id) throws Exception {
        // TODO Auto-generated method stub
        return new ResourceStateDTO(resourceStateRepository.getOne(id));
    }

}
