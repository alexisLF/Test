package org.cesi.fablab.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class MaintenanceStatusEntity {
	
	
	//Propriété
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@OneToMany( targetEntity=MaintenanceEntity.class, mappedBy="statusId" )
    private List<MaintenanceEntity> maintenanceList = new ArrayList<MaintenanceEntity>();
	
	//Constructeur
	public MaintenanceStatusEntity(int id, String name, List<MaintenanceEntity> maintenanceList) {
		super();
		this.id = id;
		this.name = name;
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

	public List<MaintenanceEntity> getMaintenanceList() {
		return maintenanceList;
	}

	public void setMaintenanceList(List<MaintenanceEntity> maintenanceList) {
		this.maintenanceList = maintenanceList;
	}
}	
