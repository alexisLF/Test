package org.cesi.fablab.api.dto;

import javax.validation.constraints.NotNull;

import org.cesi.fablab.api.entity.CapacitationEntity;

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
    @NotNull
    private String name;
    private String description;

    public CapacitationDTO(final CapacitationEntity capacitationEntity) {
        super();
        this.id = capacitationEntity.getId();
        this.name = capacitationEntity.getName();
        this.description = capacitationEntity.getDescription();
    }

}
