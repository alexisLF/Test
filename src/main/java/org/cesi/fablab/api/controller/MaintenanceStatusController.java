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
        response.put("MESSAGE", "message d'erreur dans le cas ou d'une exception ou erreur");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/maintenancestatus")
    public ResponseEntity<Object> addMaintenanceStatus(
            @Valid @RequestBody final MaintenanceStatusDTO maintenanceStatusModel) throws Exception {

        MaintenanceStatusDTO dto = maintenanceStatusService.addMaintenanceStatus(maintenanceStatusModel);
        maintenanceStatusModel.setId(dto.getId());

        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", dto);
        response.put("DATA", maintenanceStatusModel);
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/maintenancestatus")
    public ResponseEntity<Object> updateMaintenanceStatus(
            @Valid @RequestBody final MaintenanceStatusDTO maintenanceStatusModel) throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            maintenanceStatusService.updateMaintenanceStatus(maintenanceStatusModel);
            response.put("ERROR", false);
            response.put("DATA", maintenanceStatusModel);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Entity not found");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/maintenancestatus/allByName")
    ResponseEntity<Map<String, Object>> getAllByName(@RequestParam(name = "name", defaultValue = "") final String name)
            throws Exception {
        List<MaintenanceStatusDTO> entityList = maintenanceStatusService.getMaintenanceStatusByName(name);

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
            response.put("MESSAGE", "Entity not found");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/maintenancestatus")
    public ResponseEntity<Object> deleteMaintenanceStatus(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        if (!maintenanceStatusService.removeMaintenanceStatus(id)) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Delete failed");
        } else {
            response.put("ERROR", false);
            response.put("DATA", id);
        }

        return ResponseEntity.ok(response);
    }

}
