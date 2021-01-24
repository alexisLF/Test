package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.TypeFileDTO;
import org.cesi.fablab.api.entity.TypeFileEntity;

public interface TypeFileService {
    List<TypeFileDTO> getAllTypeFile() throws Exception;

    TypeFileDTO addTypeFile(TypeFileDTO dto) throws Exception;

    boolean removeTypeFile(long id) throws Exception;

    TypeFileEntity updateTypeFile(TypeFileDTO dto) throws Exception;

    TypeFileEntity getTypeFileById(long id) throws Exception;

}
