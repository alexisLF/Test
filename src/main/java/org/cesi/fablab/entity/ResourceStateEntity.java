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
@Table(name = "resourceState")
public class ResourceStateEntity {
	//Propriété
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	
	@OneToMany( targetEntity=ResourceEntity.class, mappedBy="state" )
    private List<ResourceEntity> resourceList = new ArrayList<ResourceEntity>();
	
	
	//Constructeur
	public ResourceStateEntity(String name, List<ResourceEntity> resourceList) {
		super();
		this.name = name;
		this.resourceList = resourceList;
	}
	
	public ResourceStateEntity(int id, String name, List<ResourceEntity> resourceList) {
		super();
		this.id = id;
		this.name = name;
		this.resourceList = resourceList;
	}

	
	//Méthode
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ResourceEntity> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<ResourceEntity> resourceList) {
		this.resourceList = resourceList;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
