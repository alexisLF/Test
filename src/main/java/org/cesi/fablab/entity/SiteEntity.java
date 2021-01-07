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
	// Propriété
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;

	@Column
	private String description;

	@OneToMany(targetEntity = HolidayEntity.class, mappedBy = "site")
	private List<HolidayEntity> holidaysList = new ArrayList<HolidayEntity>();

	@OneToMany(targetEntity = RoomEntity.class, mappedBy = "site")
	private List<RoomEntity> roomsList = new ArrayList<RoomEntity>();
}
