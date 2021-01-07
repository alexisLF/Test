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
@Table(name="skill")
public class SkillEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;

	@ManyToMany
	@JoinTable( name= "skillProjet",
				joinColumns = @JoinColumn(name="skillId"),
				inverseJoinColumns = @JoinColumn( name = "projetId"))
	private List<ProjetEntity> projets = new ArrayList<ProjetEntity>();

	public SkillEntity(int id, String name, List<ProjetEntity> projets) {
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

	public List<ProjetEntity> getProjets() {
		return projets;
	}

	public void setProjets(List<ProjetEntity> projets) {
		this.projets = projets;
	}
	
	
	
}
