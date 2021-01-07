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
@Table(name = "site")
public class SiteEntity {
	//Propriété
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	
	@Column
	private String description;
	
	@OneToMany( targetEntity=HolidayEntity.class, mappedBy="siteId" )
    private List<HolidayEntity> holidayList = new ArrayList<HolidayEntity>();
	
	@OneToMany( targetEntity=RoomEntity.class, mappedBy="siteId" )
    private List<RoomEntity> roomList = new ArrayList<RoomEntity>();
	
	public List<HolidayEntity> getHolidayList() {
		return holidayList;
	}

	public void setHolidayList(List<HolidayEntity> holidayList) {
		this.holidayList = holidayList;
	}
	
	//constructeur

	public SiteEntity(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public SiteEntity(int id, String name, String description, List<HolidayEntity> holidayList, List<RoomEntity> roomList) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.holidayList = holidayList;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<RoomEntity> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<RoomEntity> roomList) {
		this.roomList = roomList;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
