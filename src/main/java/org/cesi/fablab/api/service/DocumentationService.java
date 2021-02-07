package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.DocumentationDTO;

public interface DocumentationService {
    List<DocumentationDTO> getAllDocumentation() throws Exception;

    DocumentationDTO addDocumentation(DocumentationDTO dto) throws Exception;

    boolean removeDocumentation(long id) throws Exception;

    DocumentationDTO updateDocumentation(DocumentationDTO dto) throws Exception;

    DocumentationDTO getDocumentationById(long id) throws Exception;
}
