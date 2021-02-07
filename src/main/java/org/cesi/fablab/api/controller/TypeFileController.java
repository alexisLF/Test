package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.TypeFileDTO;
import org.cesi.fablab.api.service.TypeFileService;
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
public class TypeFileController {

    @Autowired(required = true)
    private TypeFileService typeFileService;

    @GetMapping("/typefile/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", typeFileService.getAllTypeFile());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/typefile")
    public ResponseEntity<Object> addTypeFile(@Valid @RequestBody final TypeFileDTO typeFile) throws Exception {

        typeFileService.addTypeFile(typeFile);
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", typeFile);
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "Ajout réussi !");
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/typefile")
    public ResponseEntity<Object> updateTypeFile(@Valid @RequestBody final TypeFileDTO typeFile) throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            typeFileService.updateTypeFile(typeFile);
            response.put("ERROR", false);
            response.put("DATA", typeFile);
            response.put("MESSAGE", "Mise à jour réussie !");
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Type de fichier non trouvé, mise à jour impossible.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/typefile/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            TypeFileDTO dto = typeFileService.getTypeFileById(id);
            response.put("ERROR", false);
            response.put("DATA", dto);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Type de fichier non trouvé.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/typefile")
    public ResponseEntity<Object> deleteTypeFile(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        if (!typeFileService.removeTypeFile(id)) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Echec de la suppression.");
        } else {
            response.put("ERROR", false);
            response.put("DATA", id);
            response.put("MESSAGE", "Type de fichier supprimé.");
        }

        return ResponseEntity.ok(response);
    }

}
