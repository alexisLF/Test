package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.TypeOperationDTO;
import org.cesi.fablab.api.entity.TypeOperationEntity;
import org.cesi.fablab.api.repository.TypeOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOperationServiceImpl implements TypeOperationService {
    @Autowired
    private TypeOperationRepository typeOperationRepository;

    @Override
    public List<TypeOperationDTO> getAllTypesOperation() throws Exception {
        List<TypeOperationDTO> lstTypesOperationDTO = new ArrayList<TypeOperationDTO>();
        List<TypeOperationEntity> lstTypesOperationEntity = typeOperationRepository.findAll();
        if (lstTypesOperationEntity != null && !lstTypesOperationEntity.isEmpty()) {
            for (TypeOperationEntity currentTypeOperationEntity : lstTypesOperationEntity) {
                TypeOperationDTO typeOperationDTO = new TypeOperationDTO(currentTypeOperationEntity);
                lstTypesOperationDTO.add(typeOperationDTO);
            }
        }
        return lstTypesOperationDTO;
    }

    @Override
    public final TypeOperationDTO addTypeOperation(final TypeOperationDTO dto) throws Exception {
        // TODO Auto-generated method stub
        TypeOperationEntity entity = new TypeOperationEntity();
        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        typeOperationRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removeTypeOperation(final TypeOperationDTO dto) throws Exception {
        // TODO Auto-generated method stub

        TypeOperationEntity entity = typeOperationRepository.findById(dto.getId());
        if (entity != null) {
            typeOperationRepository.delete(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final TypeOperationEntity updateTypeOperation(final TypeOperationDTO dto) throws Exception {
        // TODO Auto-generated method stub
        TypeOperationEntity entity = new TypeOperationEntity();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        return typeOperationRepository.save(entity);
    }

    @Override
    public final TypeOperationEntity getTypeOperationById(final int id) throws Exception {
        // TODO Auto-generated method stub
        return typeOperationRepository.getOne(id);
    }

    @Override
    public final List<TypeOperationDTO> getTypeOperationByName(final String name) throws Exception {
        // TODO Auto-generated method stub
        List<TypeOperationDTO> lstTypesOperationDTO = new ArrayList<TypeOperationDTO>();
        List<TypeOperationEntity> lstTypesOperationEntity = typeOperationRepository.findByName(name);
        if (lstTypesOperationEntity != null && !lstTypesOperationEntity.isEmpty()) {
            for (TypeOperationEntity currentTypeOperationEntity : lstTypesOperationEntity) {
                TypeOperationDTO typeOperationDTO = new TypeOperationDTO(currentTypeOperationEntity);
                lstTypesOperationDTO.add(typeOperationDTO);
            }
        }
        return lstTypesOperationDTO;
    }
}
