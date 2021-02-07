package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.FileDTO;

public interface FileService {
    List<FileDTO> getAllFiles() throws Exception;

    FileDTO addFile(FileDTO dto) throws Exception;

    boolean removeFile(long id) throws Exception;

    FileDTO updateFile(FileDTO dto) throws Exception;

    FileDTO getFileById(long id) throws Exception;

}
