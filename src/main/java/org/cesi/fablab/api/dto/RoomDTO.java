package org.cesi.fablab.api.dto;

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
public class RoomDTO {
    private long id;
    @NotNull
    private String name;
    private String floor;
    private SiteEntity site;

    public RoomDTO(final RoomEntity roomEntity) {
        super();
        this.id = roomEntity.getId();
        this.name = roomEntity.getName();
        this.floor = roomEntity.getFloor();
        this.site = roomEntity.getSite();
    }

}
