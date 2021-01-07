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
@Table(name = "typeresource")
public class TypeResource {
	//Propriété
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	
	@OneToMany( targetEntity=ResourceEntity.class, mappedBy="type" )
    private List<ResourceEntity> roomList = new ArrayList<ResourceEntity>();
	
	//Constructeur
	public TypeResource(String name, List<ResourceEntity> roomList) {
		super();
		this.name = name;
		this.roomList = roomList;
	}
	
	public TypeResource(int id, String name, List<ResourceEntity> roomList) {
		super();
		this.id = id;
		this.name = name;
		this.roomList = roomList;
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

	public List<ResourceEntity> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<ResourceEntity> roomList) {
		this.roomList = roomList;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
