package org.cesi.fablab.api.dto;

import java.util.ArrayList;
import java.util.List;

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
	private int id;
	private String name;
	private List<MaintenanceEntity> maintenancesList = new ArrayList<MaintenanceEntity>();

	public MaintenanceStatusDTO(final MaintenanceStatusEntity maintenanceStatusEntity) {
		super();
		this.id = maintenanceStatusEntity.getId();
		this.name = maintenanceStatusEntity.getName();
		// this.maintenancesList = maintenanceStatusEntity.getMaintenancesList();
	}

}
