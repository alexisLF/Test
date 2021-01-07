package org.cesi.fablab.entity;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "holiday")
public class HolidayEntity {
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
	
	@ManyToOne
	@JoinColumn(name="siteId", nullable = false)
	private SiteEntity siteId;
	
	//Constructeur
	public HolidayEntity(Calendar dateStart, Calendar dateEnd, SiteEntity siteId) {
		super();
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.siteId = siteId;
	}
	
	public HolidayEntity(int id, Calendar dateStart, Calendar dateEnd, SiteEntity siteId) {
		super();
		this.id = id;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.siteId = siteId;
	}
	
	
	//Méthodes
	public int getId() {
		return id;
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

	public SiteEntity getSiteId() {
		return siteId;
	}

	public void setSiteId(SiteEntity siteId) {
		this.siteId = siteId;
	}
	
	
}
