package org.cesi.fablab.api.dto;

import javax.validation.constraints.NotNull;

import org.cesi.fablab.api.entity.MaintenanceStatusEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceStatusDTO {
    private long id;
    @NotNull
    private String name;

    public MaintenanceStatusDTO(final MaintenanceStatusEntity maintenanceStatusEntity) {
        super();
        this.id = maintenanceStatusEntity.getId();
        this.name = maintenanceStatusEntity.getName();
    }

}
