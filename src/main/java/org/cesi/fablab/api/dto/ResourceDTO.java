package org.cesi.fablab.api.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.cesi.fablab.api.entity.CapacitationEntity;
import org.cesi.fablab.api.entity.ResourceEntity;
import org.cesi.fablab.api.entity.SecurityGearEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDTO {
    private long id;
    @NotNull
    private String name;
    private String ref;
    private Date dateInstallation;
    private int stock;
    private Boolean isActive;
    private TypeResourceDTO type;
    private RoomDTO room;
    private ResourceStateDTO state;
    private DocumentationDTO documentation;
    private List<SecurityGearDTO> securitysList = new ArrayList<SecurityGearDTO>();
    // private List<ProjectDTO> projectList = new ArrayList<ProjectDTO>();
    // private List<ReservationDTO> reservationsList = new
    // ArrayList<ReservationDTO>();
    // private List<ResourceDTO> parentResources = new ArrayList<ResourceDTO>();
    private List<ResourceDTO> consumableResources = new ArrayList<ResourceDTO>();
    private List<CapacitationDTO> resourceCapacitationList = new ArrayList<CapacitationDTO>();

    public ResourceDTO(final ResourceEntity resourceEntity) {
        super();
        this.id = resourceEntity.getId();
        this.name = resourceEntity.getName();
        this.ref = resourceEntity.getRef();
        this.dateInstallation = resourceEntity.getDateInstallation();
        this.stock = resourceEntity.getStock();
        this.isActive = resourceEntity.getIsActive();
        this.type = new TypeResourceDTO(resourceEntity.getType());
        this.room = new RoomDTO(resourceEntity.getRoom());
        this.state = new ResourceStateDTO(resourceEntity.getState());
        this.documentation = new DocumentationDTO(resourceEntity.getDocumentation());
        for (SecurityGearEntity entity : resourceEntity.getSecuritysList()) {
            securitysList.add(new SecurityGearDTO(entity));
        }
        // this.projectList = resourceEntity.getProjectList();
        // this.reservationsList = resourceEntity.getReservationsList();
        // this.maintenancesList = resourceEntity.getMaintenancesList();
        // this.parentResources = resourceEntity.getParentResources();
        for (ResourceEntity entity : resourceEntity.getConsumableResources()) {
            consumableResources.add(new ResourceDTO(entity));
        }
        for (CapacitationEntity entity : resourceEntity.getResourceCapacitationList()) {
            resourceCapacitationList.add(new CapacitationDTO(entity));
        }
    }

}
