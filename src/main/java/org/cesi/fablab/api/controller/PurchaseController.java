package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.PurchaseDTO;
import org.cesi.fablab.api.service.PurchaseService;
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
public class PurchaseController {
    @Autowired(required = true)
    private PurchaseService purchaseService;

    @GetMapping("/purchase/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", purchaseService.getAllPurchase());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "message d'erreur dans le cas ou d'une exception ou erreur");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/purchase")
    public ResponseEntity<Object> addPurchase(@Valid @RequestBody final PurchaseDTO purchaseModel) throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            PurchaseDTO dto = purchaseService.addPurchase(purchaseModel);
            purchaseModel.setId(dto.getId());
            response.put("ERROR", false);
            response.put("DATA", dto);
            response.put("DATA", purchaseModel);
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

    @PutMapping(value = "/purchase")
    public ResponseEntity<Object> updatePurchase(@Valid @RequestBody final PurchaseDTO purchaseModel) throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            purchaseService.updatePurchase(purchaseModel);
            response.put("ERROR", false);
            response.put("DATA", purchaseModel);
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

    @GetMapping("/purchase/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final int id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            PurchaseDTO dto = purchaseService.getPurchaseById(id);
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

    @DeleteMapping(value = "/purchase")
    public ResponseEntity<Object> deletePurchase(@RequestParam(name = "id", defaultValue = "0") final int id)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        if (!purchaseService.removePurchase(id)) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Delete failed");
        } else {
            response.put("ERROR", false);
            response.put("DATA", id);
        }

        return ResponseEntity.ok(response);
    }

}
