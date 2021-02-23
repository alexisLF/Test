package org.cesi.fablab.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.cesi.fablab.api.dto.CapacitationDTO;
import org.cesi.fablab.api.dto.ResourceDTO;
import org.cesi.fablab.api.dto.SecurityGearDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resource")
public class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String ref;

    @Basic
    private java.sql.Date dateInstallation;

    @Column
    private int stock;

    @Column
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "typeId", nullable = false)
    private TypeResourceEntity type;

    @ManyToOne
    @JoinColumn(name = "roomId", nullable = false)
    private RoomEntity room;

    @ManyToOne
    @JoinColumn(name = "stateId", nullable = false)
    private ResourceStateEntity state;

    @ManyToOne
    @JoinColumn(name = "documentationId", nullable = false)
    private DocumentationEntity documentation;

    @ManyToMany
    @JoinTable(name = "resourceSecurityGear", joinColumns = @JoinColumn(name = "resourceId"), inverseJoinColumns = @JoinColumn(name = "securityGearId"))
    private List<SecurityGearEntity> securitysList = new ArrayList<SecurityGearEntity>();

    @ManyToMany
    @JoinTable(name = "resourceProject", joinColumns = @JoinColumn(name = "resourceId"), inverseJoinColumns = @JoinColumn(name = "projectId"))
    private List<ProjectEntity> projectList = new ArrayList<ProjectEntity>();

    @OneToMany(targetEntity = ReservationEntity.class, mappedBy = "resource")
    private List<ReservationEntity> reservationsList = new ArrayList<ReservationEntity>();

    @ManyToMany
    @JoinTable(name = "consumable", joinColumns = @JoinColumn(name = "resourceId"), inverseJoinColumns = @JoinColumn(name = "consumableId"))
    private List<ResourceEntity> parentResources = new ArrayList<ResourceEntity>();

    @ManyToMany
    @JoinTable(name = "consumable", joinColumns = @JoinColumn(name = "consumableId"), inverseJoinColumns = @JoinColumn(name = "resourceId"))
    private List<ResourceEntity> consumableResources = new ArrayList<ResourceEntity>();

    @ManyToMany
    @JoinTable(name = "machineCapacitation", joinColumns = @JoinColumn(name = "resourceId"), inverseJoinColumns = @JoinColumn(name = "resourceCapacitationId"))
    private List<CapacitationEntity> resourceCapacitationList = new ArrayList<CapacitationEntity>();

    public ResourceEntity(final ResourceDTO resource) {
        // TODO Auto-generated constructor stub
        super();
        this.id = resource.getId();
        this.name = resource.getName();
        this.ref = resource.getRef();
        this.dateInstallation = resource.getDateInstallation();
        this.stock = resource.getStock();
        this.isActive = resource.getIsActive();
        this.type = new TypeResourceEntity(resource.getType());
        this.room = new RoomEntity(resource.getRoom());
        this.state = new ResourceStateEntity(resource.getState());
        this.documentation = new DocumentationEntity(resource.getDocumentation());
        for (SecurityGearDTO dto : resource.getSecuritysList()) {
            securitysList.add(new SecurityGearEntity(dto));
        }
        // this.projectList = resourceEntity.getProjectList();
        // this.reservationsList = resourceEntity.getReservationsList();
        // this.maintenancesList = resourceEntity.getMaintenancesList();
        // this.parentResources = resourceEntity.getParentResources();
        for (ResourceDTO dto : resource.getConsumableResources()) {
            consumableResources.add(new ResourceEntity(dto));
        }
        for (CapacitationDTO dto : resource.getResourceCapacitationList()) {
            resourceCapacitationList.add(new CapacitationEntity(dto));
        }
    }
}
