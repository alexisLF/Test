package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.DeliveryStatusDTO;
import org.cesi.fablab.api.entity.DeliveryStatusEntity;
import org.cesi.fablab.api.service.DeliveryStatusService;
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
public class DeliveryStatusController {

    @Autowired(required = true)
    private DeliveryStatusService deliveryStatusService;

    @GetMapping("/deliverystatus/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", deliveryStatusService.getAllDeliveryStatus());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "message d'erreur dans le cas ou d'une exception ou erreur");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/deliverystatus")
    public ResponseEntity<Object> addDeliveryStatus(@Valid @RequestBody final DeliveryStatusDTO deliveryStatusModel)
            throws Exception {

        DeliveryStatusDTO dto = deliveryStatusService.addDeliveryStatus(deliveryStatusModel);
        deliveryStatusModel.setId(dto.getId());

        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", dto);
        response.put("DATA", deliveryStatusModel);
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/deliverystatus")
    public ResponseEntity<Object> updateDeliveryStatus(@Valid @RequestBody final DeliveryStatusDTO deliveryStatusModel)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            deliveryStatusService.updateDeliveryStatus(deliveryStatusModel);
            response.put("ERROR", false);
            response.put("DATA", deliveryStatusModel);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Entity not found");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/deliverystatus/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            DeliveryStatusEntity entity = deliveryStatusService.getDeliveryStatusById(id);
            DeliveryStatusDTO dto = new DeliveryStatusDTO(entity);
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

    @DeleteMapping(value = "/deliverystatus")
    public ResponseEntity<Object> deleteDeliveryStatus(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        if (!deliveryStatusService.removeDeliveryStatus(id)) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Delete failed");
        } else {
            response.put("ERROR", false);
            response.put("DATA", id);
        }

        return ResponseEntity.ok(response);
    }

}
