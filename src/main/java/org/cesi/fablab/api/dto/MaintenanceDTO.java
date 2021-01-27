package org.cesi.fablab.api.dto;

import java.util.Calendar;

import org.cesi.fablab.api.entity.MaintenanceEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceDTO {
    private long id;
    private Calendar dateStart;
    private Calendar dateEnd;
    private ResourceDTO resource;
    private UserDTO user;
    private String note;
    private boolean success;
    private TypeOperationDTO type;
    private MaintenanceStatusDTO status;

    public MaintenanceDTO(final MaintenanceEntity maintenanceEntity) {
        super();
        this.id = maintenanceEntity.getId();
        this.dateStart = maintenanceEntity.getDateStart();
        this.dateEnd = maintenanceEntity.getDateEnd();
        this.resource = new ResourceDTO(maintenanceEntity.getResource());
        this.user = new UserDTO(maintenanceEntity.getUser());
        this.note = maintenanceEntity.getNote();
        this.success = maintenanceEntity.isSuccess();
        this.type = new TypeOperationDTO(maintenanceEntity.getType());
        this.status = new MaintenanceStatusDTO(maintenanceEntity.getStatus());
    }

    public MaintenanceDTO(final MaintenanceEntity maintenanceEntity, boolean needType) {
        super();
        this.id = maintenanceEntity.getId();
        this.dateStart = maintenanceEntity.getDateStart();
        this.dateEnd = maintenanceEntity.getDateEnd();
        if (needType) {
            this.resource = new ResourceDTO(maintenanceEntity.getResource());
        }
        this.user = new UserDTO(maintenanceEntity.getUser());
        this.note = maintenanceEntity.getNote();
        this.success = maintenanceEntity.isSuccess();
        this.type = new TypeOperationDTO(maintenanceEntity.getType());
        this.status = new MaintenanceStatusDTO(maintenanceEntity.getStatus(), needType);
    }

}
