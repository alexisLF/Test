package org.cesi.fablab.api.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.cesi.fablab.api.dto.FileDTO;
import org.cesi.fablab.api.entity.FileEntity;
import org.cesi.fablab.api.entity.TypeFileEntity;
import org.cesi.fablab.api.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
                lstFilesDTO.add(fileDTO);
            }
        }
        return lstFilesDTO;
    }

    private final Path root = Paths.get("uploads");

    @Override
    public void init() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public void save(final MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    public Resource load(final String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }

    @Override
    public List<FileDTO> getFilesByDocumentationId(final long idDocumentation) throws Exception {
        List<FileDTO> lstFileDTO = new ArrayList<FileDTO>();
        List<FileEntity> lstFileEntity = fileRepository.findFilesByDocumentationId(idDocumentation);
        if (lstFileEntity != null && !lstFileEntity.isEmpty()) {
            for (FileEntity currentFileEntity : lstFileEntity) {
                FileDTO fileDTO = new FileDTO(currentFileEntity);
                lstFileDTO.add(fileDTO);
            }
        }
        return lstFileDTO;
    }

    @Override
    public final FileDTO getFileById(final long id) throws Exception {
        // TODO Auto-generated method stub
        return new FileDTO(fileRepository.getOne(id));
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

    public final FileDTO addFile(final FileDTO dto) throws Exception {
        // TODO Auto-generated method stub
        FileEntity entity = new FileEntity();
        entity.setName(dto.getName());
        entity.setUrl(dto.getUrl());
        entity.setDateUpload(dto.getDateUpload());
        TypeFileEntity typeFile = new TypeFileEntity();
        typeFile.setId(dto.getType().getId());
        entity.setType(typeFile);
        fileRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }
}
