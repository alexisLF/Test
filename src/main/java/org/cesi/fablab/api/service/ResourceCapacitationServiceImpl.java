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
    public List<ResourceCapacitationDTO> getAllResourceCapacitations() throws Exception {
        List<ResourceCapacitationDTO> lstResourceCapacitationsDTO = new ArrayList<ResourceCapacitationDTO>();
        List<ResourceCapacitationEntity> lstResourceCapacitationsEntity = resourceCapacitationRepository.findAll();
        if (lstResourceCapacitationsEntity != null && !lstResourceCapacitationsEntity.isEmpty()) {
            for (ResourceCapacitationEntity currentResourceCapacitationEntity : lstResourceCapacitationsEntity) {
                ResourceCapacitationDTO resourceCapacitationDTO = new ResourceCapacitationDTO(
                        currentResourceCapacitationEntity);
                lstResourceCapacitationsDTO.add(resourceCapacitationDTO);
            }
        }
        return lstResourceCapacitationsDTO;
    }

    @Override
    public final void addResourceCapacitation(final ResourceCapacitationDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public final void removeResourceCapacitation(final ResourceCapacitationDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public final void updateResourceCapacitation(final ResourceCapacitationDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

}
