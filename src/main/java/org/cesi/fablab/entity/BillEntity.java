package org.cesi.fablab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class BillEntity {
	
	//Propriétés
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@ManyToOne
	@JoinColumn(name="purchaseId", nullable = false)
	private PurchaseEntity purchase;
	
	//Constructeur
	public BillEntity(int id, String name, PurchaseEntity purchase) {
		super();
		this.id = id;
		this.name = name;
		this.purchase = purchase;
	}
	
	
	//Méthodes
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
	public PurchaseEntity getPurchase() {
		return purchase;
	}
	public void setPurchase(PurchaseEntity purchase) {
		this.purchase = purchase;
	}
	
	
	
}
