package org.cesi.fablab.api.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Maintenance")
public class MaintenanceEntity {

    // Propriété
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Calendar dateStart;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Calendar dateEnd;

    @ManyToOne
    @JoinColumn(name = "resourceId", nullable = false)
    private ResourceEntity resource;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;

    @Column
    private String note;

    @Column
    private boolean success;

    @ManyToOne
    @JoinColumn(name = "typeId", nullable = false)
    private TypeOperationEntity type;

    @ManyToOne
    @JoinColumn(name = "statusId", nullable = false)
    private MaintenanceStatusEntity status;
}
