package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.FileDTO;

public interface FileService {
    List<FileDTO> getAllFiles() throws Exception;

    void addFile(FileDTO dto) throws Exception;

    void removeFile(FileDTO dto) throws Exception;

    void updateFile(FileDTO dto) throws Exception;

}
