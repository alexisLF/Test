package org.cesi.fablab.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    private int id;
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
}
