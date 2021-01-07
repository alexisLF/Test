package org.cesi.fablab.entity;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "reservation")
public class ReservationEntity
{
	//Propriété
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private int priority;
	@ManyToOne
	@JoinColumn(name="userId", nullable = false)
	private UserEntity userId;
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Calendar dateStart;
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Calendar dateEnd;
	@ManyToOne
	@JoinColumn(name="resourceId", nullable = false)
	private ResourceEntity resourceId;
	
	//Constructeur
	public ReservationEntity(int id, String title, String description, int priority, UserEntity userId,
			Calendar dateStart, Calendar dateEnd, ResourceEntity resourceId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.userId = userId;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.resourceId = resourceId;
	}
	
	//Méthodes
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}

	public java.util.Calendar getDateStart() {
		return dateStart;
	}

	public void setDateStart(java.util.Calendar dateStart) {
		this.dateStart = dateStart;
	}

	public java.util.Calendar getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(java.util.Calendar dateEnd) {
		this.dateEnd = dateEnd;
	}

	public ResourceEntity getResourceId() {
		return resourceId;
	}

	public void setResourceId(ResourceEntity resourceId) {
		this.resourceId = resourceId;
	}	
}
