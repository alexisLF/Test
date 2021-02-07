package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.DeliveryStatusDTO;
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
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/deliverystatus")
    public ResponseEntity<Object> addDeliveryStatus(@Valid @RequestBody final DeliveryStatusDTO deliveryStatus)
            throws Exception {

        deliveryStatusService.addDeliveryStatus(deliveryStatus);
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", deliveryStatus);
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "Ajout réussi !");
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/deliverystatus")
    public ResponseEntity<Object> updateDeliveryStatus(@Valid @RequestBody final DeliveryStatusDTO deliveryStatus)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            deliveryStatusService.updateDeliveryStatus(deliveryStatus);
            response.put("ERROR", false);
            response.put("DATA", deliveryStatus);
            response.put("MESSAGE", "Mise à jour réussie !");
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Statut de livraison non trouvé, mise à jour impossible.");
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
            DeliveryStatusDTO dto = deliveryStatusService.getDeliveryStatusById(id);
            response.put("ERROR", false);
            response.put("DATA", dto);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Statut de livraison non trouvé.");
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
            response.put("MESSAGE", "Echec de la suppression.");
        } else {
            response.put("ERROR", false);
            response.put("DATA", id);
            response.put("MESSAGE", "Statut de livraison supprimé.");
        }

        return ResponseEntity.ok(response);
    }

}
