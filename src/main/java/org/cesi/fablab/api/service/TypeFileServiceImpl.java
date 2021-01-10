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
	public List<TypeFileDTO> getAllTypesFile() throws Exception {
		List<TypeFileDTO> lstTypesFileDTO = new ArrayList<TypeFileDTO>();
		List<TypeFileEntity> lstTypesFileEntity = typeFileRepository.findAll();
		if (lstTypesFileEntity != null && !lstTypesFileEntity.isEmpty()) {
			for (TypeFileEntity currentTypeFileEntity : lstTypesFileEntity) {
				TypeFileDTO typeFileDTO = new TypeFileDTO(currentTypeFileEntity);
				lstTypesFileDTO.add(typeFileDTO);
			}
		}
		return lstTypesFileDTO;
	}

	@Override
	public final void addTypeFile(final TypeFileDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public final void removeTypeFile(final TypeFileDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public final void updateTypeFile(final TypeFileDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

}
