package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.DocumentationDTO;
import org.cesi.fablab.api.entity.DocumentationEntity;
import org.cesi.fablab.api.service.DocumentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = { "/core/api/v1" })
public class DocumentationController {

    @Autowired(required = true)
    private DocumentationService documentationService;

    @GetMapping("/documentation/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", documentationService.getAllDocumentation());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "message d'erreur dans le cas ou d'une exception ou erreur");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/documentation")
    public ResponseEntity<Object> addDocumentation(@Valid @RequestBody final DocumentationDTO documentationModel)
            throws Exception {

        DocumentationDTO dto = documentationService.addDocumentation(documentationModel);
        documentationModel.setId(dto.getId());

        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", dto);
        response.put("DATA", documentationModel);
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/documentation")
    public ResponseEntity<Object> updateDocumentation(@Valid @RequestBody final DocumentationDTO documentationModel)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            documentationService.updateDocumentation(documentationModel);
            response.put("ERROR", false);
            response.put("DATA", documentationModel);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Entity not found");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/documentation/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            DocumentationEntity entity = documentationService.getDocumentationById(id);
            DocumentationDTO dto = new DocumentationDTO(entity);
            response.put("ERROR", false);
            response.put("DATA", dto);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Entity not found");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/documentation")
    public ResponseEntity<Object> deleteDocumentation(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        if (!documentationService.removeDocumentation(id)) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Delete failed");
        } else {
            response.put("ERROR", false);
            response.put("DATA", id);
        }

        return ResponseEntity.ok(response);
    }

}
