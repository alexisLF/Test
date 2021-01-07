package org.cesi.fablab.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "deliveryStatus")
public class DeliveryStatusEntity {
	
	//Propriété
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	
	@OneToMany( targetEntity=PurchaseEntity.class, mappedBy="delivery" )
    private List<PurchaseEntity> purchaseList = new ArrayList<PurchaseEntity>();
	
	//Constructeur
	public DeliveryStatusEntity(int id, String name, List<PurchaseEntity> purchaseList) {
		super();
		this.id = id;
		this.name = name;
		this.purchaseList = purchaseList;
	}
	
	//Méthode

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

	public List<PurchaseEntity> getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(List<PurchaseEntity> purchaseList) {
		this.purchaseList = purchaseList;
	}
}
