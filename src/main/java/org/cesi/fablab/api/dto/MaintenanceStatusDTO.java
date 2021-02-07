package org.cesi.fablab.api.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.cesi.fablab.api.entity.MaintenanceEntity;
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
    private List<MaintenanceDTO> maintenancesList = new ArrayList<MaintenanceDTO>();

    public MaintenanceStatusDTO(final MaintenanceStatusEntity maintenanceStatusEntity) {
        super();
        this.id = maintenanceStatusEntity.getId();
        this.name = maintenanceStatusEntity.getName();
        this.maintenancesList = this.setMaintenancesList(maintenanceStatusEntity.getMaintenancesList());
    }

    public MaintenanceStatusDTO(final MaintenanceStatusEntity maintenanceStatusEntity, boolean needMaintenance) {
        super();
        this.id = maintenanceStatusEntity.getId();
        this.name = maintenanceStatusEntity.getName();
        if (needMaintenance) {
            this.maintenancesList = this.setMaintenancesList(maintenanceStatusEntity.getMaintenancesList());
        }
    }

    private List<MaintenanceDTO> setMaintenancesList(List<MaintenanceEntity> maintenances) {
        List<MaintenanceDTO> list = new ArrayList<MaintenanceDTO>();
        for (MaintenanceEntity maintenance : maintenances) {
            list.add(new MaintenanceDTO(maintenance));
        }
        return list;
    }

}
