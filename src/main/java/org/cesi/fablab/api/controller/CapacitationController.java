package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.CapacitationDTO;
import org.cesi.fablab.api.service.CapacitationService;
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
public class CapacitationController {

    @Autowired(required = true)
    private CapacitationService capacitationService;

    @GetMapping("/capacitation/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", capacitationService.getAllCapacitation());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/capacitation")
    public ResponseEntity<Object> addCapacitation(@Valid @RequestBody final CapacitationDTO capacitation)
            throws Exception {

        capacitationService.addCapacitation(capacitation);
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", capacitation);
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "Ajout réussi !");
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/capacitation")
    public ResponseEntity<Object> updateCapacitation(@Valid @RequestBody final CapacitationDTO capacitation)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            capacitationService.updateCapacitation(capacitation);
            response.put("ERROR", false);
            response.put("DATA", capacitation);
            response.put("MESSAGE", "Mise à jour réussie !");
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Habilitation non trouvée, mise à jour impossible.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/capacitation/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            CapacitationDTO dto = capacitationService.getCapacitationById(id);
            response.put("ERROR", false);
            response.put("DATA", dto);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Habilitation non trouvée.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/capacitation")
    public ResponseEntity<Object> deleteCapacitation(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            if (!capacitationService.removeCapacitation(id)) {
                response.put("ERROR", true);
                response.put("MESSAGE", "Echec de la suppression.");
            } else {
                response.put("ERROR", false);
                response.put("DATA", id);
                response.put("MESSAGE", "Habilitation supprimée.");
            }
        } catch (Exception exception) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Cet habilitation est utilisé, vous ne pouvez pas le supprimer");
        }
        return ResponseEntity.ok(response);
    }

}
