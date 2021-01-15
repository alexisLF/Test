package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.RoomDTO;

public interface RoomService {
	public List<RoomDTO> getAllRooms() throws Exception;

	public void addRoom(RoomDTO dto) throws Exception;

	public void removeRoom(RoomDTO dto) throws Exception;

	public void updateRoom(RoomDTO dto) throws Exception;

}
