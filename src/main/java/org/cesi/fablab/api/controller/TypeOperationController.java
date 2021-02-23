package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.TypeOperationDTO;
import org.cesi.fablab.api.service.TypeOperationService;
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
public class TypeOperationController {

    @Autowired(required = true)
    private TypeOperationService typeOperationService;

    @GetMapping("/typeoperation/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", typeOperationService.getAllTypesOperation());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/typeoperation")
    public ResponseEntity<Object> addTypeOperation(@Valid @RequestBody final TypeOperationDTO typeOperation)
            throws Exception {

        typeOperationService.addTypeOperation(typeOperation);
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", typeOperation);
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "Ajout réussi !");
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/typeoperation")
    public ResponseEntity<Object> updateTypeOperation(@Valid @RequestBody final TypeOperationDTO typeOperation)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            typeOperationService.updateTypeOperation(typeOperation);
            response.put("ERROR", false);
            response.put("DATA", typeOperation);
            response.put("MESSAGE", "Mise à jour réussie !");
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Type d'opération non trouvé, mise à jour impossible.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/typeoperation/allByName")
    ResponseEntity<Map<String, Object>> getAllByName(@RequestParam(name = "name", defaultValue = "") final String name)
            throws Exception {
        List<TypeOperationDTO> typeOperations = typeOperationService.getTypeOperationByName(name);

        Map<String, Object> response = new HashMap<>();
        if (!typeOperations.isEmpty()) {
            response.put("ERROR", false);
            response.put("DATA", typeOperations);
        } else {
            response.put("ERROR", true);
            response.put("MESSAGE", "Il n'existe pas de type d'opération à ce nom.");
        }
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/typeoperation/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            TypeOperationDTO dto = typeOperationService.getTypeOperationById(id);
            response.put("ERROR", false);
            response.put("DATA", dto);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Type d'opération non trouvé.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/typeoperation")
    public ResponseEntity<Object> deleteTypeOperation(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            if (!typeOperationService.removeTypeOperation(id)) {
                response.put("ERROR", true);
                response.put("MESSAGE", "Echec de la suppression.");
            } else {
                response.put("ERROR", false);
                response.put("DATA", id);
                response.put("MESSAGE", "Achat supprimé.");
            }
        } catch (Exception exception) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Ce type d'opération est utilisé, vous ne pouvez pas le supprimer");
        }
        return ResponseEntity.ok(response);
    }

}
