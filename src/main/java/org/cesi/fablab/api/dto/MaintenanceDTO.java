package org.cesi.fablab.api.dto;

import java.util.Calendar;

import org.cesi.fablab.api.entity.MaintenanceEntity;
import org.cesi.fablab.api.entity.MaintenanceStatusEntity;
import org.cesi.fablab.api.entity.ResourceEntity;
import org.cesi.fablab.api.entity.TypeOperationEntity;
import org.cesi.fablab.api.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceDTO {
	private int id;
	private Calendar dateStart;
	private Calendar dateEnd;
	private ResourceEntity ressource;
	private UserEntity user;
	private String note;
	private boolean success;
	private TypeOperationEntity type;
	private MaintenanceStatusEntity status;

	public MaintenanceDTO(final MaintenanceEntity maintenanceEntity) {
		super();
		this.id = maintenanceEntity.getId();
		this.dateStart = maintenanceEntity.getDateStart();
		this.dateEnd = maintenanceEntity.getDateEnd();
		// this.ressource = maintenanceEntity.getRessource();
		// this.user = maintenanceEntity.getUser();
		this.note = maintenanceEntity.getNote();
		this.success = maintenanceEntity.isSuccess();
		// this.type = maintenanceEntity.getType();
		// this.status = maintenanceEntity.getStatus();
	}

}
