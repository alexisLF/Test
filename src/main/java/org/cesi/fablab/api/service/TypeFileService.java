package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.TypeFileDTO;

public interface TypeFileService {
	List<TypeFileDTO> getAllTypesFile() throws Exception;

	void addTypeFile(TypeFileDTO dto) throws Exception;

	void removeTypeFile(TypeFileDTO dto) throws Exception;

	void updateTypeFile(TypeFileDTO dto) throws Exception;

}
