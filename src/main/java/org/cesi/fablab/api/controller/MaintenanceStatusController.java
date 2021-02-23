package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.MaintenanceStatusDTO;
import org.cesi.fablab.api.service.MaintenanceStatusService;
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
public class MaintenanceStatusController {

    @Autowired(required = true)
    private MaintenanceStatusService maintenanceStatusService;

    @GetMapping("/maintenancestatus/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", maintenanceStatusService.getAllMaintenanceStatus());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/maintenancestatus")
    public ResponseEntity<Object> addMaintenanceStatus(@Valid @RequestBody final MaintenanceStatusDTO maintenanceStatus)
            throws Exception {

        maintenanceStatusService.addMaintenanceStatus(maintenanceStatus);
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", maintenanceStatus);
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "Ajout réussi !");
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/maintenancestatus")
    public ResponseEntity<Object> updateMaintenanceStatus(
            @Valid @RequestBody final MaintenanceStatusDTO maintenanceStatus) throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            maintenanceStatusService.updateMaintenanceStatus(maintenanceStatus);
            response.put("ERROR", false);
            response.put("DATA", maintenanceStatus);
            response.put("MESSAGE", "Mise à jour réussie !");
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Statut de maintenance non trouvé, mise à jour impossible.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/maintenancestatus/allByName")
    ResponseEntity<Map<String, Object>> getAllByName(@RequestParam(name = "name", defaultValue = "") final String name)
            throws Exception {
        List<MaintenanceStatusDTO> maintenanceStatuses = maintenanceStatusService.getMaintenanceStatusByName(name);

        Map<String, Object> response = new HashMap<>();
        if (!maintenanceStatuses.isEmpty()) {
            response.put("ERROR", false);
            response.put("DATA", maintenanceStatuses);
        } else {
            response.put("ERROR", true);
            response.put("MESSAGE", "Il n'y a pas de maintenance avec ce statut.");
        }
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/maintenancestatus/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            MaintenanceStatusDTO dto = maintenanceStatusService.getMaintenanceStatusById(id);
            response.put("ERROR", false);
            response.put("DATA", dto);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Statut de maintenance non trouvé.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/maintenancestatus")
    public ResponseEntity<Object> deleteMaintenanceStatus(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            if (!maintenanceStatusService.removeMaintenanceStatus(id)) {
                response.put("ERROR", true);
                response.put("MESSAGE", "Echec de la suppression.");
            } else {
                response.put("ERROR", false);
                response.put("DATA", id);
                response.put("MESSAGE", "Statut de maintenance supprimé.");
            }
        } catch (Exception exception) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Ce statut de maintenance est utilisé, vous ne pouvez pas le supprimer");
        }

        return ResponseEntity.ok(response);
    }

}
