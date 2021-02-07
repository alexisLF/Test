package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.TypeResourceDTO;
import org.cesi.fablab.api.service.TypeResourceService;
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
public class TypeResourceController {

    @Autowired(required = true)
    private TypeResourceService typeResourceService;

    @GetMapping("/typeresource/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", typeResourceService.getAllTypesResource());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/typeresource")
    public ResponseEntity<Object> addTypeResource(@Valid @RequestBody final TypeResourceDTO typeResource)
            throws Exception {

        typeResourceService.addTypeResource(typeResource);
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", typeResource);
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "Ajout réussi !");
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/typeresource")
    public ResponseEntity<Object> updateTypeResource(@Valid @RequestBody final TypeResourceDTO typeResource)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            typeResourceService.updateTypeResource(typeResource);
            response.put("ERROR", false);
            response.put("DATA", typeResource);
            response.put("MESSAGE", "Mise à jour réussie !");
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Type de ressource non trouvé, mise à jour impossible.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/typeresource/allByName")
    ResponseEntity<Map<String, Object>> getAllByName(@RequestParam(name = "name", defaultValue = "") final String name)
            throws Exception {
        List<TypeResourceDTO> typeResources = typeResourceService.getTypeResourceByName(name);

        Map<String, Object> response = new HashMap<>();
        if (!typeResources.isEmpty()) {
            response.put("ERROR", false);
            response.put("DATA", typeResources);
        } else {
            response.put("ERROR", true);
            response.put("MESSAGE", "Il n'existe pas de type de ressource avec ce nom.");
        }
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/typeresource/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            TypeResourceDTO dto = typeResourceService.getTypeResourceById(id);
            response.put("ERROR", false);
            response.put("DATA", dto);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Type de ressource non trouvé.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/typeresource")
    public ResponseEntity<Object> deleteTypeResource(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        if (!typeResourceService.removeTypeResource(id)) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Echec de la suppression.");
        } else {
            response.put("ERROR", false);
            response.put("DATA", id);
            response.put("MESSAGE", "Type de ressource supprimé.");
        }

        return ResponseEntity.ok(response);
    }

}
