package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.CapacitationDTO;
import org.cesi.fablab.api.entity.CapacitationEntity;
import org.cesi.fablab.api.repository.CapacitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapacitationServiceImpl implements CapacitationService {
    @Autowired
    private CapacitationRepository capacitationRepository;

    @Override
    public List<CapacitationDTO> getAllCapacitation() throws Exception {
        List<CapacitationDTO> lstCapacitationDTO = new ArrayList<CapacitationDTO>();
        List<CapacitationEntity> lstCapacitationEntity = capacitationRepository.findAll();
        if (lstCapacitationEntity != null && !lstCapacitationEntity.isEmpty()) {
            for (CapacitationEntity currentCapacitationEntity : lstCapacitationEntity) {
                CapacitationDTO capacitationDTO = new CapacitationDTO(currentCapacitationEntity);
                lstCapacitationDTO.add(capacitationDTO);
            }
        }
        return lstCapacitationDTO;
    }

    @Override
    public final CapacitationDTO addCapacitation(final CapacitationDTO dto) throws Exception {
        // TODO Auto-generated method stub
        CapacitationEntity entity = new CapacitationEntity();
        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        capacitationRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removeCapacitation(final long id) throws Exception {
        // TODO Auto-generated method stub

        CapacitationEntity entity = capacitationRepository.findById(id);
        if (entity != null) {
            capacitationRepository.delete(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final CapacitationDTO updateCapacitation(final CapacitationDTO dto) throws Exception {
        // TODO Auto-generated method stub
        CapacitationEntity entity = capacitationRepository.getOne(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        return new CapacitationDTO(capacitationRepository.save(entity));
    }

    @Override
    public final CapacitationDTO getCapacitationById(final long id) throws Exception {
        // TODO Auto-generated method stub
        return new CapacitationDTO(capacitationRepository.getOne(id));
    }

}
