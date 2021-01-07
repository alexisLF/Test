package org.cesi.fablab.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tag")
public class TagEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;

	@ManyToMany
	@JoinTable( name= "tagProjet",
				joinColumns = @JoinColumn(name="tagId"),
				inverseJoinColumns = @JoinColumn( name = "projetId"))
	private List<ProjectEntity> projets = new ArrayList<ProjectEntity>();
	
	public TagEntity(int id, String name, List<ProjectEntity> projets) {
		super();
		this.id = id;
		this.name = name;
		this.projets = projets;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<ProjectEntity> getProjets() {
		return projets;
	}

	public void setProjets(List<ProjectEntity> projets) {
		this.projets = projets;
	}

}
