package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.MaintenanceDTO;
import org.cesi.fablab.api.entity.MaintenanceEntity;
import org.cesi.fablab.api.service.MaintenanceService;
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
public class MaintenanceController {
    @Autowired(required = true)
    private MaintenanceService maintenanceService;

    @GetMapping("/maintenance/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", maintenanceService.getAllMaintenances());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "message d'erreur dans le cas ou d'une exception ou erreur");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/maintenance")
    public ResponseEntity<Object> addMaintenance(@Valid @RequestBody final MaintenanceDTO maintenanceModel)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            MaintenanceDTO dto = maintenanceService.addMaintenance(maintenanceModel);
            maintenanceModel.setId(dto.getId());
            response.put("ERROR", false);
            response.put("DATA", dto);
            response.put("DATA", maintenanceModel);
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

    @PutMapping(value = "/maintenance")
    public ResponseEntity<Object> updateMaintenance(@Valid @RequestBody final MaintenanceDTO maintenanceModel)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            maintenanceService.updateMaintenance(maintenanceModel);
            response.put("ERROR", false);
            response.put("DATA", maintenanceModel);
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

    @GetMapping("/maintenance/allByResource")
    ResponseEntity<Map<String, Object>> getAllByResource(
            @RequestParam(name = "idResource", defaultValue = "") final long idResource) throws Exception {
        List<MaintenanceDTO> entityList = maintenanceService.getMaintenancesByResource(idResource);

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

    @GetMapping("/maintenance/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final int id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            MaintenanceEntity entity = maintenanceService.getMaintenanceById(id);
            MaintenanceDTO dto = new MaintenanceDTO(entity);
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

    @DeleteMapping(value = "/maintenance")
    public ResponseEntity<Object> deleteMaintenance(@Valid @RequestBody final MaintenanceDTO maintenanceModel)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        if (!maintenanceService.removeMaintenance(maintenanceModel)) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Delete failed");
        } else {
            response.put("ERROR", false);
            response.put("DATA", maintenanceModel);
        }

        return ResponseEntity.ok(response);
    }

}
