package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.SiteDTO;
import org.cesi.fablab.api.service.SiteService;
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
public class SiteController {

    @Autowired(required = true)
    private SiteService siteService;

    @GetMapping("/site/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", siteService.getAllSites());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/site")
    public ResponseEntity<Object> addSite(@Valid @RequestBody final SiteDTO site) throws Exception {

        siteService.addSite(site);
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", site);
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/site")
    public ResponseEntity<Object> updateSite(@Valid @RequestBody final SiteDTO site) throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            siteService.updateSite(site);
            response.put("ERROR", false);
            response.put("DATA", site);
            response.put("MESSAGE", "Mise à jour réussie !");
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Site non trouvé, mise à jour impossible.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/site/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final int id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            SiteDTO dto = siteService.getSiteById(id);
            response.put("ERROR", false);
            response.put("DATA", dto);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Site non trouvé.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/site")
    public ResponseEntity<Object> deleteSite(@RequestParam(name = "id", defaultValue = "0") final long id)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            if (!siteService.removeSite(id)) {
                response.put("ERROR", true);
                response.put("MESSAGE", "Echec de la suppression.");
            } else {
                response.put("ERROR", false);
                response.put("DATA", id);
                response.put("MESSAGE", "Site supprimé.");
            }
        } catch (Exception exception) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Ce site est utilisé, vous ne pouvez pas le supprimer");
        }

        return ResponseEntity.ok(response);
    }

}
