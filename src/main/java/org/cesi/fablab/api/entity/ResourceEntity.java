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
// Propriété
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
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

    @OneToMany(targetEntity = ConsumableEntity.class, mappedBy = "resource")
    private List<ConsumableEntity> consumablesList = new ArrayList<ConsumableEntity>();

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

    @OneToMany(targetEntity = ReservationEntity.class, mappedBy = "resource")
    private List<MaintenanceEntity> maintenancesList = new ArrayList<MaintenanceEntity>();

    @ManyToMany
    @JoinTable(name = "consumable", joinColumns = @JoinColumn(name = "resourceId"), inverseJoinColumns = @JoinColumn(name = "consumableId"))
    private List<ResourceEntity> parentResources = new ArrayList<ResourceEntity>();

    @ManyToMany
    @JoinTable(name = "consumable", joinColumns = @JoinColumn(name = "consumableId"), inverseJoinColumns = @JoinColumn(name = "resourceId"))
    private List<ResourceEntity> consumableResources = new ArrayList<ResourceEntity>();

    @ManyToMany
    @JoinTable(name = "machineCapacitation", joinColumns = @JoinColumn(name = "resourceId"), inverseJoinColumns = @JoinColumn(name = "resourceCapacitationId"))
    private List<CapacitationEntity> resourceCapacitationList = new ArrayList<CapacitationEntity>();
}
