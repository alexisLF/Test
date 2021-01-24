package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.FileDTO;
import org.cesi.fablab.api.entity.FileEntity;

public interface FileService {
    List<FileDTO> getAllFiles() throws Exception;

    FileDTO addFile(FileDTO dto) throws Exception;

    boolean removeFile(long id) throws Exception;

    FileEntity updateFile(FileDTO dto) throws Exception;

    FileEntity getFileById(long id) throws Exception;

}
