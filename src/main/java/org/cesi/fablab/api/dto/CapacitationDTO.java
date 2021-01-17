package org.cesi.fablab.api.dto;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.entity.CapacitationEntity;
import org.cesi.fablab.api.entity.RoleEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CapacitationDTO {
    private long id;
    private String name;
    private String description;
    private List<RoleEntity> rolesList = new ArrayList<RoleEntity>();

    public CapacitationDTO(final CapacitationEntity capacitationEntity) {
        super();
        this.id = capacitationEntity.getId();
        this.name = capacitationEntity.getName();
        this.description = capacitationEntity.getDescription();
        // this.rolesList = capacitationEntity.getRolesList();
    }

}
