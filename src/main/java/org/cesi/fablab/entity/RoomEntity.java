package org.cesi.fablab.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class RoomEntity {
	
	//Propriété
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String floor;

	@ManyToOne
	@JoinColumn(name="siteId", nullable = false)
	private SiteEntity siteId;
	
	@OneToMany( targetEntity=ResourceEntity.class, mappedBy="room" )
    private List<ResourceEntity> resourceList = new ArrayList<ResourceEntity>();
	
	
	//Constructeur
	public RoomEntity(String name, String floor, SiteEntity siteId) {
		super();
		this.name = name;
		this.floor = floor;
		this.siteId = siteId;
	}
	
	public RoomEntity(int id, String name, String floor, SiteEntity siteId) {
		super();
		this.id = id;
		this.name = name;
		this.floor = floor;
		this.siteId = siteId;
	}

	//Méthodes

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public SiteEntity getSiteId() {
		return siteId;
	}

	public void setSiteId(SiteEntity siteId) {
		this.siteId = siteId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ResourceEntity> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<ResourceEntity> resourceList) {
		this.resourceList = resourceList;
	}
	
	
	
	
}
