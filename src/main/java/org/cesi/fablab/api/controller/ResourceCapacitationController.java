package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.ResourceCapacitationDTO;
import org.cesi.fablab.api.service.ResourceCapacitationService;
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
public class ResourceCapacitationController {

    @Autowired(required = true)
    private ResourceCapacitationService resourceCapacitationService;

    @GetMapping("/resourcecapacitation/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", resourceCapacitationService.getAllResourceCapacitation());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "message d'erreur dans le cas ou d'une exception ou erreur");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/resourcecapacitation")
    public ResponseEntity<Object> addResourceCapacitation(
            @Valid @RequestBody final ResourceCapacitationDTO resourceCapacitationModel) throws Exception {

        ResourceCapacitationDTO dto = resourceCapacitationService.addResourceCapacitation(resourceCapacitationModel);
        resourceCapacitationModel.setId(dto.getId());

        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", dto);
        response.put("DATA", resourceCapacitationModel);
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/resourcecapacitation")
    public ResponseEntity<Object> updateResourceCapacitation(
            @Valid @RequestBody final ResourceCapacitationDTO resourceCapacitationModel) throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            resourceCapacitationService.updateResourceCapacitation(resourceCapacitationModel);
            response.put("ERROR", false);
            response.put("DATA", resourceCapacitationModel);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Entity not found");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/resourcecapacitation/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            ResourceCapacitationDTO dto = resourceCapacitationService.getResourceCapacitationById(id);
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

    @DeleteMapping(value = "/resourcecapacitation")
    public ResponseEntity<Object> deleteResourceCapacitation(
            @RequestParam(name = "id", defaultValue = "0") final long id) throws Exception {

        Map<String, Object> response = new HashMap<>();
        if (!resourceCapacitationService.removeResourceCapacitation(id)) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Delete failed");
        } else {
            response.put("ERROR", false);
            response.put("DATA", id);
        }

        return ResponseEntity.ok(response);
    }

}
