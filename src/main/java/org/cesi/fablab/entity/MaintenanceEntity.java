package org.cesi.fablab.entity;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class MaintenanceEntity {
	
	//Propriété
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Calendar dateStart;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Calendar dateEnd;
	
	@JoinColumn(name="resourceId", nullable = false)
	private ResourceEntity resourceId;
	
	@ManyToOne
	@JoinColumn(name="userId", nullable = false)
	private UserEntity userId;
	
	@Column
	private String note;
	
	@Column
	private boolean success;
	
	@ManyToOne
	@JoinColumn(name="typeId", nullable = false)
	private TypeOperationEntity typeId;
	
	@ManyToOne
	@JoinColumn(name="statusId", nullable = false)
	private MaintenanceStatusEntity statusId;
	
	//Constructeur
	public MaintenanceEntity(int id, Calendar dateStart, Calendar dateEnd, ResourceEntity resourceId, UserEntity userId,
			String note, boolean success, TypeOperationEntity typeId, MaintenanceStatusEntity statusId) {
		super();
		this.id = id;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.resourceId = resourceId;
		this.userId = userId;
		this.note = note;
		this.success = success;
		this.typeId = typeId;
		this.statusId = statusId;
	}
	
	//Methodes
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public TypeOperationEntity getTypeId() {
		return typeId;
	}

	public void setTypeId(TypeOperationEntity typeId) {
		this.typeId = typeId;
	}

	public MaintenanceStatusEntity getStatusId() {
		return statusId;
	}

	public void setStatusId(MaintenanceStatusEntity statusId) {
		this.statusId = statusId;
	}
	
	
	
}
