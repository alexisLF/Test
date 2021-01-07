package org.cesi.fablab.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
