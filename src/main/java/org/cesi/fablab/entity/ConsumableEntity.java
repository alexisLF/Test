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
@Table(name = "consumable")
public class ConsumableEntity {
	
	//Propriété
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name="resourceId", nullable = false)
	private ResourceEntity resource;
	
	@Column
	private float value;
	
	//Constructeur
	public ConsumableEntity(String name, ResourceEntity resource, float value) {
		super();
		this.name = name;
		this.resource = resource;
		this.value = value;
	}
	
	public ConsumableEntity(int id, String name, ResourceEntity resource, float value) {
		super();
		this.id = id;
		this.name = name;
		this.resource = resource;
		this.value = value;
	}
	
	//Méthodes

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ResourceEntity getResource() {
		return resource;
	}

	public void setResource(ResourceEntity resource) {
		this.resource = resource;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
	
}
