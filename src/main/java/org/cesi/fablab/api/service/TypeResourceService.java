package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.TypeResourceDTO;

public interface TypeResourceService {
	List<TypeResourceDTO> getAllTypesResource() throws Exception;

	void addTypeResource(TypeResourceDTO dto) throws Exception;

	void removeTypeResource(TypeResourceDTO dto) throws Exception;

	void updateTypeResource(TypeResourceDTO dto) throws Exception;

}
