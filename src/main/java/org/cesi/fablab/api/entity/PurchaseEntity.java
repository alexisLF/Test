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
@Table(name = "purchase")
public class PurchaseEntity {
    // Propriété
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Basic
    private java.sql.Date purchaseDate;
    @ManyToOne
    @JoinColumn(name = "resourceId", nullable = false)
    private ResourceEntity ressource;

    @ManyToOne
    @JoinColumn(name = "deliveryId", nullable = false)
    private DeliveryStatusEntity delivery;

    @ManyToMany
    @JoinTable(name = "purchaseFiles", joinColumns = @JoinColumn(name = "purchaseId"), inverseJoinColumns = @JoinColumn(name = "fileId"))
    private List<FileEntity> filesList = new ArrayList<FileEntity>();
}
