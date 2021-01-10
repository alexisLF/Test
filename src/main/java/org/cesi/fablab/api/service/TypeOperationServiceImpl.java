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
    public final void addTypeOperation(final TypeOperationDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public final void removeTypeOperation(final TypeOperationDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public final void updateTypeOperation(final TypeOperationDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

}
