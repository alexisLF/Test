package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.ResourceDTO;
import org.cesi.fablab.api.entity.ResourceEntity;
import org.cesi.fablab.api.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public List<ResourceDTO> getAllResources() throws Exception {
        List<ResourceDTO> lstResourcesDTO = new ArrayList<ResourceDTO>();
        List<ResourceEntity> lstResourcesEntity = resourceRepository.findAll();
        if (lstResourcesEntity != null && !lstResourcesEntity.isEmpty()) {
            for (ResourceEntity currentRessourceEntity : lstResourcesEntity) {
                ResourceDTO resourceDTO = new ResourceDTO(currentRessourceEntity);
                lstResourcesDTO.add(resourceDTO);
            }
        }
        return lstResourcesDTO;
    }

    @Override
    public final void addResource(final ResourceDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public final void removeResource(final ResourceDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public final void updateResource(final ResourceDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

}
