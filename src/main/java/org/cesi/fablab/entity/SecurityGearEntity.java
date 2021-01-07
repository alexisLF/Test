package org.cesi.fablab.entity;

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
import javax.persistence.Table;

@Entity
@Table(name = "securitygear")
public class SecurityGearEntity {
	
	//Propriété
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	
	@ManyToMany
    @JoinTable( name = "documentFiles",
                joinColumns = @JoinColumn( name = "securityGearId" ),
                inverseJoinColumns = @JoinColumn( name = "resourceId" ) )
    private List<ResourceEntity> resource = new ArrayList<ResourceEntity>();
	
	//Constructeur
	public SecurityGearEntity(int id, String name, List<ResourceEntity> resource) {
		super();
		this.id = id;
		this.name = name;
		this.resource = resource;
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

	public List<ResourceEntity> getResource() {
		return resource;
	}

	public void setResource(List<ResourceEntity> resource) {
		this.resource = resource;
	}
	
	
	
}
