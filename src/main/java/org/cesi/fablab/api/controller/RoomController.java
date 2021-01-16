package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.cesi.fablab.api.dto.RoomDTO;
import org.cesi.fablab.api.entity.RoomEntity;
import org.cesi.fablab.api.service.RoomService;
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
public class RoomController {
    @Autowired(required = true)
    private RoomService roomService;

    @GetMapping("/room/all")
    ResponseEntity<Map<String, Object>> all() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("ERROR", false);
        response.put("DATA", roomService.getAllRooms());
        response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
        response.put("MESSAGE", "message d'erreur dans le cas ou d'une exception ou erreur");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/room")
    public ResponseEntity<Object> addRoom(@Valid @RequestBody final RoomDTO roomModel) throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            RoomDTO dto = roomService.addRoom(roomModel);
            roomModel.setId(dto.getId());
            response.put("ERROR", false);
            response.put("DATA", dto);
            response.put("DATA", roomModel);
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

    @PutMapping(value = "/room")
    public ResponseEntity<Object> updateRoom(@Valid @RequestBody final RoomDTO roomModel) throws Exception {

        Map<String, Object> response = new HashMap<>();
        try {
            roomService.updateRoom(roomModel);
            response.put("ERROR", false);
            response.put("DATA", roomModel);
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

    @GetMapping("/room/allBySite")
    ResponseEntity<Map<String, Object>> getAllBySite(
            @RequestParam(name = "idSite", defaultValue = "") final long idSite) throws Exception {
        List<RoomDTO> entityList = roomService.getRoomsBySite(idSite);

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

    @GetMapping("/room/oneById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(name = "id", defaultValue = "0") final int id)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        try {
            RoomEntity entity = roomService.getRoomById(id);
            RoomDTO dto = new RoomDTO(entity);
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

    @DeleteMapping(value = "/room")
    public ResponseEntity<Object> deleteRoom(@Valid @RequestBody final RoomDTO roomModel) throws Exception {

        Map<String, Object> response = new HashMap<>();
        if (!roomService.removeRoom(roomModel)) {
            response.put("ERROR", true);
            response.put("MESSAGE", "Delete failed");
        } else {
            response.put("ERROR", false);
            response.put("DATA", roomModel);
        }

        return ResponseEntity.ok(response);
    }

}
