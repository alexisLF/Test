package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.TypeFileDTO;
import org.cesi.fablab.api.entity.TypeFileEntity;
import org.cesi.fablab.api.repository.TypeFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeFileServiceImpl implements TypeFileService {
    @Autowired
    private TypeFileRepository typeFileRepository;

    @Override
    public List<TypeFileDTO> getAllTypeFile() throws Exception {
        List<TypeFileDTO> lstTypeFileDTO = new ArrayList<TypeFileDTO>();
        List<TypeFileEntity> lstTypeFileEntity = typeFileRepository.findAll();
        if (lstTypeFileEntity != null && !lstTypeFileEntity.isEmpty()) {
            for (TypeFileEntity currentTypeFileEntity : lstTypeFileEntity) {
                TypeFileDTO typeFileDTO = new TypeFileDTO(currentTypeFileEntity);
                lstTypeFileDTO.add(typeFileDTO);
            }
        }
        return lstTypeFileDTO;
    }

    @Override
    public final TypeFileDTO addTypeFile(final TypeFileDTO dto) throws Exception {
        // TODO Auto-generated method stub
        TypeFileEntity entity = new TypeFileEntity();
        entity.setName(dto.getName());
        typeFileRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removeTypeFile(final long id) throws Exception {
        // TODO Auto-generated method stub

        TypeFileEntity entity = typeFileRepository.findById(id);
        if (entity != null) {
            typeFileRepository.delete(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final TypeFileEntity updateTypeFile(final TypeFileDTO dto) throws Exception {
        // TODO Auto-generated method stub
        TypeFileEntity entity = this.getTypeFileById(dto.getId());
        entity.setName(dto.getName());
        return typeFileRepository.save(entity);
    }

    @Override
    public final TypeFileEntity getTypeFileById(final long id) throws Exception {
        // TODO Auto-generated method stub
        return typeFileRepository.getOne(id);
    }

}
