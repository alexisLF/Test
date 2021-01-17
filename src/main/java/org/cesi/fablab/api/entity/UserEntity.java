package org.cesi.fablab.api.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String mail;
    @Column
    private String password;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private boolean active;
    @Column(name = "date_active")
    private LocalDateTime dateActive;
    @Column
    private String avatar;
    @Column
    private int credit;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private GroupEntity group;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity role;

    @OneToMany(targetEntity = ReservationEntity.class, mappedBy = "user")
    private List<ReservationEntity> reservationsList = new ArrayList<ReservationEntity>();

    @OneToMany(targetEntity = ProjectEntity.class, mappedBy = "creator")
    private List<ProjectEntity> projectCollaboratorsList = new ArrayList<ProjectEntity>();

    @ManyToMany
    @JoinTable(name = "projectCollaborator", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "projectId"))
    private List<ProjectEntity> projectsList = new ArrayList<ProjectEntity>();

    @ManyToMany
    @JoinTable(name = "userCapacitation", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "resourceCapacitationId"))
    private List<ResourceCapacitationEntity> userCapacitationList = new ArrayList<ResourceCapacitationEntity>();
}
