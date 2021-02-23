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
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/resource")
    public ResponseEntity<Object> addResource(@Valid @RequestBody final ResourceDTO resource) throws Exception {

        resourceService.addResource(resource);
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", resource);
        response.put("MESSAGE", "Ajout réussi !");
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);

    }

    @PutMapping(value = "/resource")
    public ResponseEntity<Object> updateResource(@Valid @RequestBody final ResourceDTO resource) throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            resourceService.updateResource(resource);
            response.put("ERROR", false);
            response.put("DATA", resource);
            response.put("MESSAGE", "Mise à jour réussie !");
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Ressource non trouvée, mise à jour impossible.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/resource/allBySite")
    ResponseEntity<Map<String, Object>> getAllBySite(
            @RequestParam(name = "idSite", defaultValue = "") final long idSite) throws Exception {
        List<ResourceDTO> resources = resourceService.getResourcesBySiteId(idSite);

        Map<String, Object> response = new HashMap<>();
        if (!resources.isEmpty()) {
            response.put("ERROR", false);
            response.put("DATA", resources);
        } else {
            response.put("ERROR", true);
            response.put("MESSAGE", "Il n'y a pas de ressource pour ce site.");
        }
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/resource/allByState")
    ResponseEntity<Map<String, Object>> getAllByState(
            @RequestParam(name = "idState", defaultValue = "") final long idSite) throws Exception {
        List<ResourceDTO> resources = resourceService.getResourcesByStateId(idSite);

        Map<String, Object> response = new HashMap<>();
        if (!resources.isEmpty()) {
            response.put("ERROR", false);
            response.put("DATA", resources);
        } else {
            response.put("ERROR", true);
            response.put("MESSAGE", "Il n'y a pas de ressource pour cet état.");
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
            response.put("MESSAGE", "Ressource non trouvée.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/resource")
    public ResponseEntity<Object> deleteResource(@RequestParam(name = "id", defaultValue = "0") final int id)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            if (!resourceService.removeResource(id)) {
                response.put("ERROR", true);
                response.put("MESSAGE", "Echec de la suppression.");
            } else {
                response.put("ERROR", false);
                response.put("DATA", id);
                response.put("MESSAGE", "Ressource supprimée.");
            }
        } catch (Exception exception) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Cette resource est utilisée, vous ne pouvez pas la supprimer");
        }
        return ResponseEntity.ok(response);
    }

}
