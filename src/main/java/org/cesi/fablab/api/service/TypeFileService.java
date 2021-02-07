package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.TypeFileDTO;

public interface TypeFileService {
    List<TypeFileDTO> getAllTypeFile() throws Exception;

    TypeFileDTO addTypeFile(TypeFileDTO dto) throws Exception;

    boolean removeTypeFile(long id) throws Exception;

    TypeFileDTO updateTypeFile(TypeFileDTO dto) throws Exception;

    TypeFileDTO getTypeFileById(long id) throws Exception;

}
