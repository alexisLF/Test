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
    public List<DocumentationDTO> getAllDocumentation() throws Exception {
        List<DocumentationDTO> lstDocumentationDTO = new ArrayList<DocumentationDTO>();
        List<DocumentationEntity> lstDocumentationEntity = documentationRepository.findAll();
        if (lstDocumentationEntity != null && !lstDocumentationEntity.isEmpty()) {
            for (DocumentationEntity currentDocumentationEntity : lstDocumentationEntity) {
                DocumentationDTO documentationDTO = new DocumentationDTO(currentDocumentationEntity);
                lstDocumentationDTO.add(documentationDTO);
            }
        }
        return lstDocumentationDTO;
    }

    @Override
    public final DocumentationDTO addDocumentation(final DocumentationDTO dto) throws Exception {
        // TODO Auto-generated method stub
        DocumentationEntity entity = new DocumentationEntity();
        entity.setDescription(dto.getDescription());
        entity.setUseCondition(dto.getUseCondition());
        documentationRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removeDocumentation(final long id) throws Exception {
        // TODO Auto-generated method stub

        DocumentationEntity entity = documentationRepository.findById(id);
        if (entity != null) {
            documentationRepository.delete(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final DocumentationDTO updateDocumentation(final DocumentationDTO dto) throws Exception {
        // TODO Auto-generated method stub
        DocumentationEntity entity = documentationRepository.getOne(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setUseCondition(dto.getUseCondition());
        return new DocumentationDTO(documentationRepository.save(entity));
    }

    @Override
    public final DocumentationDTO getDocumentationById(final long id) throws Exception {
        // TODO Auto-generated method stub
        return new DocumentationDTO(documentationRepository.getOne(id));
    }

}
