package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.DocumentationDTO;
import org.cesi.fablab.api.entity.DocumentationEntity;
import org.cesi.fablab.api.repository.DocumentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentationServiceImpl implements DocumentationService {
    @Autowired
    private DocumentationRepository documentationRepository;

    @Override
    public List<DocumentationDTO> getAllDocumentations() throws Exception {
        List<DocumentationDTO> lstDocumentationsDTO = new ArrayList<DocumentationDTO>();
        List<DocumentationEntity> lstDocumentationsEntity = documentationRepository.findAll();
        if (lstDocumentationsEntity != null && !lstDocumentationsEntity.isEmpty()) {
            for (DocumentationEntity currentDocumentationEntity : lstDocumentationsEntity) {
                DocumentationDTO documentationDTO = new DocumentationDTO(currentDocumentationEntity);
                lstDocumentationsDTO.add(documentationDTO);
            }
        }
        return lstDocumentationsDTO;
    }

    @Override
    public final void addDocumentation(final DocumentationDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public final void removeDocumentation(final DocumentationDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public final void updateDocumentation(final DocumentationDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

}
