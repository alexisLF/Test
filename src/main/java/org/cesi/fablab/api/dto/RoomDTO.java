package org.cesi.fablab.api.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.cesi.fablab.api.entity.ResourceEntity;
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
    private List<ResourceEntity> resourcesList = new ArrayList<ResourceEntity>();

    public RoomDTO(final RoomEntity roomEntity, final boolean needSite) {
        super();
        this.id = roomEntity.getId();
        this.name = roomEntity.getName();
        this.floor = roomEntity.getFloor();
        // this.resourcesList = userEntity.getResourcesList();
    }

    public RoomDTO(final RoomEntity roomEntity) {
        super();
        this.id = roomEntity.getId();
        this.name = roomEntity.getName();
        this.floor = roomEntity.getFloor();
        this.site = roomEntity.getSite();
        // this.resourcesList = userEntity.getResourcesList();
    }

}
