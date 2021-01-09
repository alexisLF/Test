package org.cesi.fablab.api.dto;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.entity.MaintenanceEntity;
import org.cesi.fablab.api.entity.TypeOperationEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeOperationDTO {
	private int id;
	private String name;
	private String description;
	private List<MaintenanceEntity> maintenancesList = new ArrayList<MaintenanceEntity>();

	public TypeOperationDTO(final TypeOperationEntity typeOperationEntity) {
		super();
		this.id = typeOperationEntity.getId();
		this.name = typeOperationEntity.getName();
		this.description = typeOperationEntity.getDescription();
		// this.maintenancesList = typeOperationEntity.getMaintenancesList();
	}

}
