package org.cesi.fablab.api.dto;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.entity.ResourceEntity;
import org.cesi.fablab.api.entity.SecurityGearEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SecurityGearDTO {
    private long id;
    private String name;
    private List<ResourceEntity> resourcesList = new ArrayList<ResourceEntity>();

    public SecurityGearDTO(SecurityGearEntity securityGearEntity) {
        super();
        this.id = securityGearEntity.getId();
        this.name = securityGearEntity.getName();
        // this.resourcesList = securityGearEntity.getResourcesList();
    }

}
