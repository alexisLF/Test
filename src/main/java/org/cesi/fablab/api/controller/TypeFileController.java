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
        response.put("MESSAGE", "message d'erreur dans le cas ou d'une exception ou erreur");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/typefile")
    public ResponseEntity<Object> addTypeFile(@Valid @RequestBody final TypeFileDTO typeFileModel) throws Exception {

        TypeFileDTO dto = typeFileService.addTypeFile(typeFileModel);
        typeFileModel.setId(dto.getId());

        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", dto);
        response.put("DATA", typeFileModel);
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/typefile")
    public ResponseEntity<Object> updateTypeFile(@Valid @RequestBody final TypeFileDTO typeFileModel) throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            typeFileService.updateTypeFile(typeFileModel);
            response.put("ERROR", false);
            response.put("DATA", typeFileModel);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Entity not found");
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
            response.put("MESSAGE", "Entity not found");
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
            response.put("MESSAGE", "Delete failed");
        } else {
            response.put("ERROR", false);
            response.put("DATA", id);
        }

        return ResponseEntity.ok(response);
    }

}
