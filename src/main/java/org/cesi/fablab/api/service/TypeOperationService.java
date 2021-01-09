package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.TypeOperationDTO;

public interface TypeOperationService {
	List<TypeOperationDTO> getAllTypesOperation() throws Exception;

	void addTypeOperation(TypeOperationDTO dto) throws Exception;

	void removeTypeOperation(TypeOperationDTO dto) throws Exception;

	void updateTypeOperation(TypeOperationDTO dto) throws Exception;

}
