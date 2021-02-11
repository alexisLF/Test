package org.cesi.fablab.api.dto;

import javax.validation.constraints.NotNull;

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

    public SecurityGearDTO(final SecurityGearEntity securityGearEntity) {
        super();
        this.id = securityGearEntity.getId();
        this.name = securityGearEntity.getName();
    }

}
