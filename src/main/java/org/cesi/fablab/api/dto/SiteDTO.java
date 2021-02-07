package org.cesi.fablab.api.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.cesi.fablab.api.entity.RoomEntity;
import org.cesi.fablab.api.entity.SiteEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SiteDTO {
    private long id;
    @NotNull
    private String name;
    private String description;
    // private List<HolidayDTO> holidaysList = new ArrayList<HolidayDTO>();
    private List<RoomDTO> roomsList = new ArrayList<RoomDTO>();

    public SiteDTO(final SiteEntity siteEntity) {
        super();
        this.id = siteEntity.getId();
        this.name = siteEntity.getName();
        this.description = siteEntity.getDescription();
        this.setRoomsList(siteEntity.getRoomsList());
        // this.holidaysList = siteEntity.getHolidaysList();
    }

    private void setRoomsList(final List<RoomEntity> rooms) {
        for (RoomEntity room : rooms) {
            this.roomsList.add(new RoomDTO(room, false));
        }
    }

}
