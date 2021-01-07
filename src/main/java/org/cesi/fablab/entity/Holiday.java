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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Holiday {
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
	private Site siteId;

	public Holiday(int id, Calendar dateStart, Calendar dateEnd, Site siteId) {
		super();
		this.id = id;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.siteId = siteId;
	}

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

	public Site getSiteId() {
		return siteId;
	}

	public void setSiteId(Site siteId) {
		this.siteId = siteId;
	}
	
	
}
