package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.PurchaseDTO;
import org.cesi.fablab.api.service.PurchaseService;
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
public class PurchaseController {
    @Autowired(required = true)
    private PurchaseService purchaseService;

    @GetMapping("/purchase/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", purchaseService.getAllPurchase());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/purchase")
    public ResponseEntity<Object> addPurchase(@Valid @RequestBody final PurchaseDTO purchase) throws Exception {

        purchaseService.addPurchase(purchase);
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", purchase);
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "Ajout réussi !");
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/purchase")
    public ResponseEntity<Object> updatePurchase(@Valid @RequestBody final PurchaseDTO purchase) throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            purchaseService.updatePurchase(purchase);
            response.put("ERROR", false);
            response.put("DATA", purchase);
            response.put("MESSAGE", "Mise à jour réussie !");
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Achat non trouvé, mise à jour impossible.");
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
            response.put("MESSAGE", "Achat non trouvé.");
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
            response.put("MESSAGE", "Echec de la suppression.");
        } else {
            response.put("ERROR", false);
            response.put("DATA", id);
            response.put("MESSAGE", "Achat supprimé.");
        }

        return ResponseEntity.ok(response);
    }

}
