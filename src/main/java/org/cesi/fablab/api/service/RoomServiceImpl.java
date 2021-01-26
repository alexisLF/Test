package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.RoomDTO;
import org.cesi.fablab.api.entity.RoomEntity;
import org.cesi.fablab.api.entity.SiteEntity;
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
                SiteEntity site = new SiteEntity();
                site.setId(roomDTO.getSite().getId());
                roomDTO.setSite(site);
                lstRoomsDTO.add(roomDTO);
            }
        }
        return lstRoomsDTO;
    }

    @Override
    public final RoomDTO addRoom(final RoomDTO dto) throws Exception {
        // TODO Auto-generated method stub
        RoomEntity entity = new RoomEntity();
        entity.setFloor(dto.getFloor());
        entity.setName(dto.getName());
        SiteEntity site = new SiteEntity();
        site.setId(dto.getSite().getId());
        entity.setSite(site);
        roomRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removeRoom(final long id) throws Exception {
        // TODO Auto-generated method stub

        RoomEntity entity = roomRepository.findById(id);
        if (entity != null) {
            roomRepository.delete(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final RoomEntity updateRoom(final RoomDTO dto) throws Exception {
        // TODO Auto-generated method stub

        RoomEntity entity = this.getRoomById(dto.getId());
        entity.setFloor(dto.getFloor());
        entity.setName(dto.getName());
        SiteEntity site = new SiteEntity();
        site.setId(dto.getSite().getId());
        entity.setSite(site);
        return roomRepository.save(entity);
    }

    @Override
    public final RoomEntity getRoomById(final long id) throws Exception {
        // TODO Auto-generated method stub

        RoomEntity roomEntity = roomRepository.getOne(id);
        SiteEntity site = new SiteEntity();
        site.setId(roomEntity.getSite().getId());
        roomEntity.setSite(site);
        return roomEntity;
    }

    @Override
    public final List<RoomDTO> getRoomsBySite(final long idSite) throws Exception {
        // TODO Auto-generated method stub
        List<RoomDTO> lstRoomsDTO = new ArrayList<RoomDTO>();
        List<RoomEntity> lstRoomsEntity = roomRepository.findBySiteId(idSite);
        if (lstRoomsEntity != null && !lstRoomsEntity.isEmpty()) {
            for (RoomEntity currentRoomEntity : lstRoomsEntity) {
                RoomDTO roomDTO = new RoomDTO(currentRoomEntity);
                SiteEntity site = new SiteEntity();
                site.setId(roomDTO.getSite().getId());
                roomDTO.setSite(site);
                lstRoomsDTO.add(roomDTO);
            }
        }
        return lstRoomsDTO;
    }

}
