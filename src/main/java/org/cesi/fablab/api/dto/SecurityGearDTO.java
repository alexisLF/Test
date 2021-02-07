package org.cesi.fablab.api.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

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
    @NotNull
    private String name;
    private List<ResourceEntity> resourcesList = new ArrayList<ResourceEntity>();

    public SecurityGearDTO(final SecurityGearEntity securityGearEntity) {
        super();
        this.id = securityGearEntity.getId();
        this.name = securityGearEntity.getName();
        // this.resourcesList = securityGearEntity.getResourcesList();
    }

}
