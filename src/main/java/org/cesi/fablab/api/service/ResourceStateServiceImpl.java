package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.ResourceStateDTO;
import org.cesi.fablab.api.entity.ResourceStateEntity;
import org.cesi.fablab.api.repository.ResourceStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceStateServiceImpl implements ResourceStateService {
    @Autowired
    private ResourceStateRepository resourceStateRepository;

    @Override
    public List<ResourceStateDTO> getAllResourceStates() throws Exception {
        List<ResourceStateDTO> lstResourceStatesDTO = new ArrayList<ResourceStateDTO>();
        List<ResourceStateEntity> lstResourceStatesEntity = resourceStateRepository.findAll();
        if (lstResourceStatesEntity != null && !lstResourceStatesEntity.isEmpty()) {
            for (ResourceStateEntity currentResourceStateEntity : lstResourceStatesEntity) {
                ResourceStateDTO resourceStateDTO = new ResourceStateDTO(currentResourceStateEntity);
                lstResourceStatesDTO.add(resourceStateDTO);
            }
        }
        return lstResourceStatesDTO;
    }

    @Override
    public final void addResourceState(final ResourceStateDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public final void removeResourceState(final ResourceStateDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public final void updateResourceState(final ResourceStateDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

}
