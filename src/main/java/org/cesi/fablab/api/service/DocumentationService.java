package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.DocumentationDTO;

public interface DocumentationService {
    List<DocumentationDTO> getAllDocumentations() throws Exception;

    void addDocumentation(DocumentationDTO dto) throws Exception;

    void removeDocumentation(DocumentationDTO dto) throws Exception;

    void updateDocumentation(DocumentationDTO dto) throws Exception;

}
