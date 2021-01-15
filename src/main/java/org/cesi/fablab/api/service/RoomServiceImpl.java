package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.RoomDTO;
import org.cesi.fablab.api.entity.RoomEntity;
import org.cesi.fablab.api.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public List<RoomDTO> getAllRooms() throws Exception {
		List<RoomDTO> lstRoomsDTO = new ArrayList<RoomDTO>();
		List<RoomEntity> lstRoomsEntity = roomRepository.findAll();
		if (lstRoomsEntity != null && !lstRoomsEntity.isEmpty()) {
			for (RoomEntity currentRoomEntity : lstRoomsEntity) {
				RoomDTO roomDTO = new RoomDTO(currentRoomEntity);
				lstRoomsDTO.add(roomDTO);
			}
		}
		return lstRoomsDTO;
	}

	@Override
	public void addRoom(RoomDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRoom(RoomDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRoom(RoomDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

}
