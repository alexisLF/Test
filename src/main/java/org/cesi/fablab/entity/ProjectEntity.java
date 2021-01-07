package org.cesi.fablab.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="project")
public class ProjectEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String title;
	
	@Column(columnDefinition="TEXT")
	private String description;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Calendar dateStart;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Calendar dateEnd;
	
	@ManyToMany
	@JoinTable( name= "skillProject",
				joinColumns = @JoinColumn(name="projetId"),
				inverseJoinColumns = @JoinColumn( name = "skillId"))
	private List<SkillEntity> skills = new ArrayList<SkillEntity>();
	
	@ManyToMany
	@JoinTable( name= "tagProjet",
				joinColumns = @JoinColumn(name="projetId"),
				inverseJoinColumns = @JoinColumn( name = "tagId"))
	private List<TagEntity> tags = new ArrayList<TagEntity>();
	
	@ManyToMany
	@JoinTable( name= "documentProjet",
				joinColumns = @JoinColumn(name="projetId"),
				inverseJoinColumns = @JoinColumn( name = "documentId"))
	private List<DocumentEntity> documents = new ArrayList<DocumentEntity>();
	
	@ManyToMany
	@JoinTable( name= "resourceProject",
				joinColumns = @JoinColumn(name="projectId"),
				inverseJoinColumns = @JoinColumn( name = "resourceId"))
	private List<ResourceEntity> resourceList = new ArrayList<ResourceEntity>();
	
	@Column
	private boolean status;
	
	@Column
	private boolean publicAccess;
	
	//Constructeur
	public ProjectEntity(int id, String title, String description, Calendar dateStart, Calendar dateEnd,
			List<SkillEntity> skills, List<TagEntity> tags, List<DocumentEntity> documents,
			List<ResourceEntity> resourceList, boolean status, boolean publicAccess) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.skills = skills;
		this.tags = tags;
		this.documents = documents;
		this.resourceList = resourceList;
		this.status = status;
		this.publicAccess = publicAccess;
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

	public List<SkillEntity> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillEntity> skills) {
		this.skills = skills;
	}

	public List<TagEntity> getTags() {
		return tags;
	}

	public void setTags(List<TagEntity> tags) {
		this.tags = tags;
	}

	public List<DocumentEntity> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentEntity> documents) {
		this.documents = documents;
	}

	public List<ResourceEntity> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<ResourceEntity> resourceList) {
		this.resourceList = resourceList;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isPublicAccess() {
		return publicAccess;
	}

	public void setPublicAccess(boolean publicAccess) {
		this.publicAccess = publicAccess;
	}
	
	
	
	
	
	

}
