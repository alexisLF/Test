package org.cesi.fablab.entity;

import java.util.ArrayList;
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
@Table(name="projet")
public class ProjetEntity {
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
	@JoinTable( name= "skillProjet",
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
	
	@Column
	private boolean status;
	
	@Column
	private boolean publicAccess;
	

}
