package org.cesi.fablab.api.dto;

import java.util.Calendar;

import javax.validation.constraints.NotNull;

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
    @NotNull
    private Calendar dateStart;
    private Calendar dateEnd;
    private ResourceDTO resource;
    private UserDTO user;
    @NotNull
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
        // this.user = new UserDTO(maintenanceEntity.getUser());
        this.note = maintenanceEntity.getNote();
        this.success = maintenanceEntity.isSuccess();
        this.type = new TypeOperationDTO(maintenanceEntity.getType());
        this.status = new MaintenanceStatusDTO(maintenanceEntity.getStatus());
    }

}
