package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.RoomDTO;

public interface RoomService {
    List<RoomDTO> getAllRooms() throws Exception;

    RoomDTO addRoom(RoomDTO dto) throws Exception;

    boolean removeRoom(long id) throws Exception;

    RoomDTO updateRoom(RoomDTO dto) throws Exception;

    List<RoomDTO> getRoomsBySite(long idSite) throws Exception;

    RoomDTO getRoomById(long id) throws Exception;

}
