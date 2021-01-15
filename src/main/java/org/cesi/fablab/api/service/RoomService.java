package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.RoomDTO;
import org.cesi.fablab.api.entity.RoomEntity;

public interface RoomService {
    List<RoomDTO> getAllRooms() throws Exception;

    RoomDTO addRoom(RoomDTO dto) throws Exception;

    boolean removeRoom(RoomDTO dto) throws Exception;

    RoomEntity updateRoom(RoomDTO dto) throws Exception;

    List<RoomDTO> getRoomsBySite(long idSite) throws Exception;

    RoomEntity getRoomById(long id) throws Exception;

}
