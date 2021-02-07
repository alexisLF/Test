package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.ResourceDTO;
import org.cesi.fablab.api.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
public class ResourceController {
    @Autowired(required = true)
    private ResourceService resourceService;

    @GetMapping("/resource/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", resourceService.getAllResources());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "message d'erreur dans le cas ou d'une exception ou erreur");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/resource")
    public ResponseEntity<Object> addResource(@Valid @RequestBody final ResourceDTO resourceModel) throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            ResourceDTO dto = resourceService.addResource(resourceModel);
            resourceModel.setId(dto.getId());
            response.put("ERROR", false);
            response.put("DATA", dto);
            response.put("DATA", resourceModel);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Entity not found");
        } catch (DataIntegrityViolationException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Data integrity violation");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }
        return ResponseEntity.ok(response);

    }

    @PutMapping(value = "/resource")
    public ResponseEntity<Object> updateResource(@Valid @RequestBody final ResourceDTO resourceModel) throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            resourceService.updateResource(resourceModel);
            response.put("ERROR", false);
            response.put("DATA", resourceModel);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Entity not found");
        } catch (DataIntegrityViolationException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Data integrity violation");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/resource/allBySite")
    ResponseEntity<Map<String, Object>> getAllBySite(
            @RequestParam(name = "idSite", defaultValue = "") final long idSite) throws Exception {
        List<ResourceDTO> entityList = resourceService.getResourcesBySiteId(idSite);

        Map<String, Object> response = new HashMap<>();
        if (!entityList.isEmpty()) {
            response.put("ERROR", false);
            response.put("DATA", entityList);
        } else {
            response.put("ERROR", true);
            response.put("MESSAGE", "List not exist");
        }
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/resource/allByState")
    ResponseEntity<Map<String, Object>> getAllByState(
            @RequestParam(name = "idState", defaultValue = "") final long idSite) throws Exception {
        List<ResourceDTO> entityList = resourceService.getResourcesByStateId(idSite);

        Map<String, Object> response = new HashMap<>();
        if (!entityList.isEmpty()) {
            response.put("ERROR", false);
            response.put("DATA", entityList);
        } else {
            response.put("ERROR", true);
            response.put("MESSAGE", "List not exist");
        }
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/resource/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final int id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            ResourceDTO dto = resourceService.getResourceById(id);
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

    @DeleteMapping(value = "/resource")
    public ResponseEntity<Object> deleteResource(@RequestParam(name = "id", defaultValue = "0") final int id)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        if (!resourceService.removeResource(id)) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Delete failed");
        } else {
            response.put("ERROR", false);
            response.put("DATA", id);
        }

        return ResponseEntity.ok(response);
    }

}
