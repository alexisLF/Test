package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.MaintenanceDTO;
import org.cesi.fablab.api.service.MaintenanceService;
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
public class MaintenanceController {
    @Autowired(required = true)
    private MaintenanceService maintenanceService;

    @GetMapping("/maintenance/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", maintenanceService.getAllMaintenances());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/maintenance")
    public ResponseEntity<Object> addMaintenance(@Valid @RequestBody final MaintenanceDTO maintenance)
            throws Exception {

        maintenanceService.addMaintenance(maintenance);
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", maintenance);
        response.put("MESSAGE", "Ajout réussi !");
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);

    }

    @PutMapping(value = "/maintenance")
    public ResponseEntity<Object> updateMaintenance(@Valid @RequestBody final MaintenanceDTO maintenance)
            throws Exception {

        maintenanceService.updateMaintenance(maintenance);
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("ERROR", false);
            response.put("DATA", maintenance);
            response.put("MESSAGE", "Mise à jour réussie !");
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Maintenance non trouvée, mise à jour impossible.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/maintenance/allByResource")
    ResponseEntity<Map<String, Object>> getAllByResource(
            @RequestParam(name = "idResource", defaultValue = "") final long idResource) throws Exception {

        List<MaintenanceDTO> maintenances = maintenanceService.getMaintenancesByResource(idResource);
        Map<String, Object> response = new HashMap<>();
        if (!maintenances.isEmpty()) {
            response.put("ERROR", false);
            response.put("DATA", maintenances);
        } else {
            response.put("ERROR", true);
            response.put("MESSAGE", "Il n'y a pas de maintenance pour cette ressource.");
        }
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/maintenance/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final int id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            MaintenanceDTO dto = maintenanceService.getMaintenanceById(id);
            response.put("ERROR", false);
            response.put("DATA", dto);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Maintenance non trouvée.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/maintenance")
    public ResponseEntity<Object> deleteMaintenance(@RequestParam(name = "id", defaultValue = "0") final int id)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            if (!maintenanceService.removeMaintenance(id)) {
                response.put("ERROR", true);
                response.put("MESSAGE", "Echec de la suppression.");
            } else {
                response.put("ERROR", false);
                response.put("DATA", id);
                response.put("MESSAGE", "Maintenance supprimée.");
            }
        } catch (Exception exception) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Cette maintenance est utilisée, vous ne pouvez pas la supprimer");
        }

        return ResponseEntity.ok(response);
    }

}
