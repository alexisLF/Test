package org.cesi.fablab.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class TypeOperation {
	
	//Propriété
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@OneToMany( targetEntity=MaintenanceEntity.class, mappedBy="typeId" )
    private List<MaintenanceEntity> maintenanceList = new ArrayList<MaintenanceEntity>();
	
	
	//Constructeur
	public TypeOperation(int id, String name, String description, List<MaintenanceEntity> maintenanceList) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.maintenanceList = maintenanceList;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<MaintenanceEntity> getMaintenanceList() {
		return maintenanceList;
	}


	public void setMaintenanceList(List<MaintenanceEntity> maintenanceList) {
		this.maintenanceList = maintenanceList;
	}
	
	
	
	
	
	
	

}
