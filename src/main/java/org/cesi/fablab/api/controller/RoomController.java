package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.RoomDTO;
import org.cesi.fablab.api.service.RoomService;
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
public class RoomController {
    @Autowired(required = true)
    private RoomService roomService;

    @GetMapping("/room/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", roomService.getAllRooms());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/room")
    public ResponseEntity<Object> addRoom(@Valid @RequestBody final RoomDTO room) throws Exception {
        roomService.addRoom(room);
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", room);
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "Ajout réussi !");
        return ResponseEntity.ok(response);

    }

    @PutMapping(value = "/room")
    public ResponseEntity<Object> updateRoom(@Valid @RequestBody final RoomDTO room) throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            roomService.updateRoom(room);
            response.put("ERROR", false);
            response.put("DATA", room);
            response.put("MESSAGE", "Mise à jour réussie !");
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Salle non trouvée, mise à jour impossible.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/room/allBySite")
    ResponseEntity<Map<String, Object>> getAllBySite(
            @RequestParam(name = "idSite", defaultValue = "") final long idSite) throws Exception {
        List<RoomDTO> rooms = roomService.getRoomsBySite(idSite);

        Map<String, Object> response = new HashMap<>();
        if (!rooms.isEmpty()) {
            response.put("ERROR", false);
            response.put("DATA", rooms);
        } else {
            response.put("ERROR", true);
            response.put("MESSAGE", "Il n'y a pas de salle pour ce site.");
        }
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/room/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final int id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            RoomDTO dto = roomService.getRoomById(id);
            response.put("ERROR", false);
            response.put("DATA", dto);
        } catch (EntityNotFoundException e) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Salle non trouvée.");
        } finally {
            response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/room")
    public ResponseEntity<Object> deleteRoom(@RequestParam(name = "id", defaultValue = "0") final int id)
            throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            if (!roomService.removeRoom(id)) {
                response.put("ERROR", true);
                response.put("MESSAGE", "Echec de la suppression.");
            } else {
                response.put("ERROR", false);
                response.put("DATA", id);
                response.put("MESSAGE", "Salle supprimée.");
            }
        } catch (Exception exception) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Cette salle est utilisée, vous ne pouvez pas la supprimer");
        }

        return ResponseEntity.ok(response);
    }

}
