package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.cesi.fablab.api.dto.DocumentationDTO;
import org.cesi.fablab.api.dto.FileDTO;
import org.cesi.fablab.api.entity.DocumentationEntity;
import org.cesi.fablab.api.entity.FileEntity;
import org.cesi.fablab.api.entity.TypeFileEntity;
import org.cesi.fablab.api.repository.DocumentationRepository;
import org.cesi.fablab.api.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentationServiceImpl implements DocumentationService {
    @Autowired
    private DocumentationRepository documentationRepository;
    @Autowired
    private FileRepository fileRepository;

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
        List<DocumentationEntity> documentationEntity = new ArrayList<DocumentationEntity>();
        documentationEntity.add(entity);
        TypeFileEntity type = new TypeFileEntity();
        type.setId(1);

        List<FileDTO> lstFilesDTO = dto.getFilesList();
        for (FileDTO currentFileDTO : lstFilesDTO) {
            FileEntity currentFileEntity = new FileEntity();
            currentFileEntity.setName(currentFileDTO.getName());
            currentFileEntity.setUrl(currentFileDTO.getUrl());
            currentFileEntity.setDateUpload(Calendar.getInstance());
            currentFileEntity.setType(type);
            currentFileEntity.setDocumentationsList(documentationEntity);
            fileRepository.save(currentFileEntity);
        }

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
        documentationRepository.save(entity);

        List<DocumentationEntity> documentationEntity = new ArrayList<DocumentationEntity>();
        documentationEntity.add(entity);
        TypeFileEntity type = new TypeFileEntity();
        type.setId(1);

        List<FileDTO> lstFilesDTO = dto.getFilesList();
        for (FileDTO currentFileDTO : lstFilesDTO) {
            FileEntity currentFileEntity = new FileEntity();
            currentFileEntity.setName(currentFileDTO.getName());
            currentFileEntity.setUrl(currentFileDTO.getUrl());
            currentFileEntity.setDateUpload(Calendar.getInstance());
            currentFileEntity.setType(type);
            currentFileEntity.setDocumentationsList(documentationEntity);
            fileRepository.save(currentFileEntity);
        }

        return new DocumentationDTO(documentationRepository.save(entity));
    }

    @Override
    public final DocumentationDTO getDocumentationById(final long id) throws Exception {
        // TODO Auto-generated method stub
        return new DocumentationDTO(documentationRepository.getOne(id));
    }
}
