package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.SecurityGearDTO;
import org.cesi.fablab.api.entity.SecurityGearEntity;
import org.cesi.fablab.api.service.SecurityGearService;
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
public class SecurityGearController {

    @Autowired(required = true)
    private SecurityGearService securityGearService;

    @GetMapping("/securitygear/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", securityGearService.getAllSecurityGears());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "message d'erreur dans le cas ou d'une exception ou erreur");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/securitygear")
    public ResponseEntity<Object> addSecurityGear(@Valid @RequestBody final SecurityGearDTO securityGearModel)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            SecurityGearDTO dto = securityGearService.addSecurityGear(securityGearModel);
            securityGearModel.setId(dto.getId());
            response.put("ERROR", false);
            response.put("DATA", dto);
            response.put("DATA", securityGearModel);
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

    @PutMapping(value = "/securitygear")
    public ResponseEntity<Object> updateSecurityGear(@Valid @RequestBody final SecurityGearDTO securityGearModel)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            securityGearService.updateSecurityGear(securityGearModel);
            response.put("ERROR", false);
            response.put("DATA", securityGearModel);
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

    @GetMapping("/securitygear/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final int id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            SecurityGearEntity entity = securityGearService.getSecurityGearById(id);
            SecurityGearDTO dto = new SecurityGearDTO(entity);
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

    @DeleteMapping(value = "/securitygear")
    public ResponseEntity<Object> deleteSecurityGear(@Valid @RequestBody final SecurityGearDTO securityGearModel)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        if (!securityGearService.removeSecurityGear(securityGearModel)) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Delete failed");
        } else {
            response.put("ERROR", false);
            response.put("DATA", securityGearModel);
        }

        return ResponseEntity.ok(response);
    }
}
