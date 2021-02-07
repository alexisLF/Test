package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.ResourceStateDTO;
import org.cesi.fablab.api.service.ResourceStateService;
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
public class ResourceStateController {

    @Autowired(required = true)
    private ResourceStateService resourceStateService;

    @GetMapping("/resourcestate/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", resourceStateService.getAllResourceState());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "message d'erreur dans le cas ou d'une exception ou erreur");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/resourcestate")
    public ResponseEntity<Object> addResourceState(@Valid @RequestBody final ResourceStateDTO resourceStateModel)
            throws Exception {

        ResourceStateDTO dto = resourceStateService.addResourceState(resourceStateModel);
        resourceStateModel.setId(dto.getId());

        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", dto);
        response.put("DATA", resourceStateModel);
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/resourcestate")
    public ResponseEntity<Object> updateResourceState(@Valid @RequestBody final ResourceStateDTO resourceStateModel)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            resourceStateService.updateResourceState(resourceStateModel);
            response.put("ERROR", false);
            response.put("DATA", resourceStateModel);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Entity not found");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/resourcestate/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            ResourceStateDTO dto = resourceStateService.getResourceStateById(id);
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

    @DeleteMapping(value = "/resourcestate")
    public ResponseEntity<Object> deleteResourceState(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        if (!resourceStateService.removeResourceState(id)) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Delete failed");
        } else {
            response.put("ERROR", false);
            response.put("DATA", id);
        }

        return ResponseEntity.ok(response);
    }

}
