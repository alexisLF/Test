package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.DocumentationDTO;
import org.cesi.fablab.api.entity.DocumentationEntity;

public interface DocumentationService {
    List<DocumentationDTO> getAllDocumentation() throws Exception;

    DocumentationDTO addDocumentation(DocumentationDTO dto) throws Exception;

    boolean removeDocumentation(long id) throws Exception;

    DocumentationEntity updateDocumentation(DocumentationDTO dto) throws Exception;

    DocumentationEntity getDocumentationById(long id) throws Exception;
}
