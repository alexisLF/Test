package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.TypeResourceDTO;
import org.cesi.fablab.api.entity.TypeResourceEntity;
import org.cesi.fablab.api.repository.TypeResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeResourceServiceImpl implements TypeResourceService {
    @Autowired
    private TypeResourceRepository typeResourceRepository;

    @Override
    public List<TypeResourceDTO> getAllTypesResource() throws Exception {
        List<TypeResourceDTO> lstTypesResourceDTO = new ArrayList<TypeResourceDTO>();
        List<TypeResourceEntity> lstTypesResourceEntity = typeResourceRepository.findAll();
        if (lstTypesResourceEntity != null && !lstTypesResourceEntity.isEmpty()) {
            for (TypeResourceEntity currentTypeResourceEntity : lstTypesResourceEntity) {
                TypeResourceDTO typeResourceDTO = new TypeResourceDTO(currentTypeResourceEntity);
                lstTypesResourceDTO.add(typeResourceDTO);
            }
        }
        return lstTypesResourceDTO;
    }

    @Override
    public final TypeResourceDTO addTypeResource(final TypeResourceDTO dto) throws Exception {
        // TODO Auto-generated method stub
        TypeResourceEntity entity = new TypeResourceEntity();
        entity.setName(dto.getName());
        typeResourceRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removeTypeResource(final long id) throws Exception {
        // TODO Auto-generated method stub

        TypeResourceEntity entity = typeResourceRepository.findById(id);
        if (entity != null) {
            typeResourceRepository.delete(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final TypeResourceEntity updateTypeResource(final TypeResourceDTO dto) throws Exception {
        // TODO Auto-generated method stub
        TypeResourceEntity entity = this.getTypeResourceById(dto.getId());
        entity.setName(dto.getName());
        return typeResourceRepository.save(entity);
    }

    @Override
    public final TypeResourceEntity getTypeResourceById(final long id) throws Exception {
        // TODO Auto-generated method stub
        return typeResourceRepository.getOne(id);
    }

    @Override
    public final List<TypeResourceDTO> getTypeResourceByName(final String name) throws Exception {
        // TODO Auto-generated method stub
        List<TypeResourceDTO> lstTypesResourceDTO = new ArrayList<TypeResourceDTO>();
        List<TypeResourceEntity> lstTypesResourceEntity = typeResourceRepository.findByName(name);
        if (lstTypesResourceEntity != null && !lstTypesResourceEntity.isEmpty()) {
            for (TypeResourceEntity currentTypeResourceEntity : lstTypesResourceEntity) {
                TypeResourceDTO typeResourceDTO = new TypeResourceDTO(currentTypeResourceEntity);
                lstTypesResourceDTO.add(typeResourceDTO);
            }
        }
        return lstTypesResourceDTO;
    }

}
