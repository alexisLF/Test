package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.FileDTO;
import org.cesi.fablab.api.entity.FileEntity;
import org.cesi.fablab.api.entity.TypeFileEntity;
import org.cesi.fablab.api.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepository fileRepository;

    @Override
    public List<FileDTO> getAllFiles() throws Exception {
        List<FileDTO> lstFilesDTO = new ArrayList<FileDTO>();
        List<FileEntity> lstFilesEntity = fileRepository.findAll();
        if (lstFilesEntity != null && !lstFilesEntity.isEmpty()) {
            for (FileEntity currentFileEntity : lstFilesEntity) {
                FileDTO fileDTO = new FileDTO(currentFileEntity);
                TypeFileEntity typeFile = new TypeFileEntity();
                typeFile.setId(fileDTO.getType().getId());
                fileDTO.setType(typeFile);
                lstFilesDTO.add(fileDTO);
            }
        }
        return lstFilesDTO;
    }

    @Override
    public final FileDTO addFile(final FileDTO dto) throws Exception {
        // TODO Auto-generated method stub
        FileEntity entity = new FileEntity();
        entity.setName(dto.getName());
        entity.setUrl(dto.getUrl());
        entity.setDateUpload(dto.getDateUpload());
        TypeFileEntity typeFile = new TypeFileEntity();
        typeFile.setId(dto.getType().getId());
        dto.setType(typeFile);
        fileRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removeFile(final long id) throws Exception {
        // TODO Auto-generated method stub

        FileEntity entity = fileRepository.findById(id);
        if (entity != null) {
            fileRepository.delete(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final FileEntity updateFile(final FileDTO dto) throws Exception {
        // TODO Auto-generated method stub
        FileEntity entity = this.getFileById(dto.getId());
        entity.setName(dto.getName());
        TypeFileEntity typeFile = new TypeFileEntity();
        typeFile.setId(dto.getType().getId());
        dto.setType(typeFile);
        return fileRepository.save(entity);
    }

    @Override
    public final FileEntity getFileById(final long id) throws Exception {
        // TODO Auto-generated method stub
        return fileRepository.getOne(id);
    }

}
