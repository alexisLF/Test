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
			for (TypeResourceEntity currentTypeRessourceEntity : lstTypesResourceEntity) {
				TypeResourceDTO typeResourceDTO = new TypeResourceDTO(currentTypeRessourceEntity);
				lstTypesResourceDTO.add(typeResourceDTO);
			}
		}
		return lstTypesResourceDTO;
	}

	@Override
	public final void addTypeResource(final TypeResourceDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public final void removeTypeResource(final TypeResourceDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public final void updateTypeResource(final TypeResourceDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

}
