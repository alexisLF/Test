package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.TypeOperationDTO;

public interface TypeOperationService {
    List<TypeOperationDTO> getAllTypesOperation() throws Exception;

    TypeOperationDTO addTypeOperation(TypeOperationDTO dto) throws Exception;

    boolean removeTypeOperation(long id) throws Exception;

    TypeOperationDTO updateTypeOperation(TypeOperationDTO dto) throws Exception;

    TypeOperationDTO getTypeOperationById(long id) throws Exception;

    List<TypeOperationDTO> getTypeOperationByName(String name) throws Exception;
}
