package org.cesi.fablab.entity;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase")
public class PurchaseEntity {
	//Propriété
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Basic
	private java.sql.Date purchaseDate;
	@ManyToOne
	@JoinColumn(name="resourceId", nullable = false)
	private ResourceEntity ressource;
	
	@ManyToOne
	@JoinColumn(name="deliveryId", nullable = false)
	private DeliveryStatusEntity delivery;
	
	
	//Constructeur
	public PurchaseEntity(int id, String name, Date purchaseDate, ResourceEntity ressource, DeliveryStatusEntity delivery) {
		super();
		this.id = id;
		this.name = name;
		this.purchaseDate = purchaseDate;
		this.ressource = ressource;
		this.delivery = delivery;
	}

	
	//Methode
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public java.sql.Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(java.sql.Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public ResourceEntity getRessource() {
		return ressource;
	}

	public void setRessource(ResourceEntity ressource) {
		this.ressource = ressource;
	}

	public DeliveryStatusEntity getDelivery() {
		return delivery;
	}

	public void setDelivery(DeliveryStatusEntity delivery) {
		this.delivery = delivery;
	}
}
