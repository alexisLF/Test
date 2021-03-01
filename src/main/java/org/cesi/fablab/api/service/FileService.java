package org.cesi.fablab.api.service;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.cesi.fablab.api.dto.FileDTO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    List<FileDTO> getAllFiles() throws Exception;

    void init();

    void save(MultipartFile file);

    Resource load(String filename);

    Stream<Path> loadAll();

    List<FileDTO> getFilesByDocumentationId(long idDocumentation) throws Exception;

    List<FileDTO> getFilesByPurchaseId(long idPurchase) throws Exception;

    FileDTO getFileById(long id) throws Exception;

    boolean removeFile(long id) throws Exception;

    FileDTO addFile(FileDTO dto) throws Exception;

}
