package org.cesi.fablab.api.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.entity.CapacitationEntity;
import org.cesi.fablab.api.entity.DocumentationEntity;
import org.cesi.fablab.api.entity.MaintenanceEntity;
import org.cesi.fablab.api.entity.ProjectEntity;
import org.cesi.fablab.api.entity.ReservationEntity;
import org.cesi.fablab.api.entity.ResourceEntity;
import org.cesi.fablab.api.entity.ResourceStateEntity;
import org.cesi.fablab.api.entity.RoomEntity;
import org.cesi.fablab.api.entity.SecurityGearEntity;
import org.cesi.fablab.api.entity.TypeResourceEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDTO {
	private int id;
	private String name;
	private String ref;
	private Date dateInstallation;
	private int stock;
	private Boolean isActive;
	private TypeResourceEntity type;
	private RoomEntity room;
	private ResourceStateEntity state;
	private DocumentationEntity documentation;
	private List<SecurityGearEntity> securitysList = new ArrayList<SecurityGearEntity>();
	private List<ProjectEntity> projectList = new ArrayList<ProjectEntity>();
	private List<ReservationEntity> reservationsList = new ArrayList<ReservationEntity>();
	private List<MaintenanceEntity> maintenancesList = new ArrayList<MaintenanceEntity>();
	private List<ResourceEntity> parentResources = new ArrayList<ResourceEntity>();
	private List<ResourceEntity> consumableResources = new ArrayList<ResourceEntity>();
	private List<CapacitationEntity> resourceCapacitationList = new ArrayList<CapacitationEntity>();

	public ResourceDTO(final ResourceEntity resourceEntity) {
		super();
		this.id = resourceEntity.getId();
		this.name = resourceEntity.getName();
		this.ref = resourceEntity.getRef();
		this.dateInstallation = resourceEntity.getDateInstallation();
		this.stock = resourceEntity.getStock();
		this.isActive = resourceEntity.getIsActive();
		// this.type = resourceEntity.getType();
		// this.room = resourceEntity.getRoom();
		// this.state = resourceEntity.getState();
		// this.documentation = resourceEntity.getDocumentation();
		// this.securitysList = resourceEntity.getSecuritysList();
		// this.projectList = resourceEntity.getProjectList();
		// this.reservationsList = resourceEntity.getReservationsList();
		// this.maintenancesList = resourceEntity.getMaintenancesList();
		// this.parentResources = resourceEntity.getParentResources();
		// this.consumableResources = resourceEntity.getConsumableResources();
		// this.resourceCapacitationList = resourceEntity.getResourceCapacitationList();
	}

}
