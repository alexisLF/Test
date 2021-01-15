package org.cesi.fablab.api.dto;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.entity.HolidayEntity;
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
    private String name;
    private String description;
    private List<HolidayEntity> holidaysList = new ArrayList<HolidayEntity>();
    private List<RoomEntity> roomsList = new ArrayList<RoomEntity>();

    public SiteDTO(SiteEntity siteEntity) {
        super();
        this.id = siteEntity.getId();
        this.name = siteEntity.getName();
        this.description = siteEntity.getDescription();
        // this.holidaysList = siteEntity.getHolidaysList();
        // this.roomsList = siteEntity.getRoomsList();
    }

}
