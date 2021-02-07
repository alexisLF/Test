package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.TypeResourceDTO;

public interface TypeResourceService {
    List<TypeResourceDTO> getAllTypesResource() throws Exception;

    TypeResourceDTO addTypeResource(TypeResourceDTO dto) throws Exception;

    boolean removeTypeResource(long id) throws Exception;

    TypeResourceDTO updateTypeResource(TypeResourceDTO dto) throws Exception;

    TypeResourceDTO getTypeResourceById(long id) throws Exception;

    List<TypeResourceDTO> getTypeResourceByName(String name) throws Exception;

}
