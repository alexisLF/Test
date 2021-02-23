package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.cesi.fablab.api.dto.DocumentationDTO;
import org.cesi.fablab.api.dto.FileDTO;
import org.cesi.fablab.api.service.DocumentationService;
import org.cesi.fablab.api.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@RestController
@RequestMapping(path = { "/core/api/v1" })
public class FileController {

    @Autowired(required = true)
    private FileService fileService;

    @Autowired(required = true)
    private DocumentationService documentationService;

    @DeleteMapping(value = "/files")
    public ResponseEntity<Object> deleteFile(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try{
	        if (!fileService.removeFile(id)) {
	            response.put("ERROR", true);
	            response.put("MESSAGE", "Echec de la suppression.");
	        } else {
	            response.put("ERROR", false);
	            response.put("DATA", id);
	            response.put("MESSAGE", "Fichier supprimé.");
	        }
        } catch (Exception exception) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Ce fichier est utilisé, vous ne pouvez pas le supprimer");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/files/upload")
    public ResponseEntity<Object> uploadFiles(@RequestParam("files") final MultipartFile[] files) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<String> fileNames = new ArrayList<>();

            Arrays.asList(files).stream().forEach(file -> {
                fileService.save(file);
                fileNames.add(file.getOriginalFilename());
            });

            response.put("ERROR", false);
            response.put("DATA", fileNames);
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
            response.put("MESSAGE", "Uploaded the files successfully: " + fileNames);

        } catch (Exception e) {

            response.put("ERROR", true);
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
            response.put("MESSAGE", "Fail to upload files!");
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/files")
    public ResponseEntity<Map<String, Object>> getFiles(final long idDocumentation) {
        Map<String, Object> response = new HashMap<>();

        try {
            DocumentationDTO documentationDTO = documentationService.getDocumentationById(idDocumentation);
            List<FileDTO> filesDTO = documentationDTO.getFilesList().stream().map(path -> {
                String filename = path.getName().toString();
                String url = MvcUriComponentsBuilder
                        .fromMethodName(FileController.class, "downloadFile", path.getName().toString()).build()
                        .toString();

                return new FileDTO(filename, url);
            }).collect(Collectors.toList());

            response.put("ERROR", false);
            response.put("DATA", filesDTO);
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            response.put("ERROR", true);
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Object> downloadFile(@PathVariable final String filename) {
        Resource file = fileService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @GetMapping("/files/filesByDocumentation")
    ResponseEntity<Map<String, Object>> getFilesByDocumentation(
            @RequestParam(name = "id", defaultValue = "0") final long id) throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            FileDTO dto = fileService.getFileById(id);
            response.put("ERROR", false);
            response.put("DATA", dto);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Fichier non trouvé.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }
        return ResponseEntity.ok(response);
    }

}
