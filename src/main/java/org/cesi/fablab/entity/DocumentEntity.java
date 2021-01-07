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
@Table(name="document")
public class DocumentEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column(columnDefinition="TEXT")
	private String description;
	
	@Column
	private String path;

	@ManyToMany
	@JoinTable( name= "documentProjet",
				joinColumns = @JoinColumn(name="documentId"),
				inverseJoinColumns = @JoinColumn( name = "projetId"))
	private List<ProjetEntity> projets = new ArrayList<ProjetEntity>();
	
	public DocumentEntity(int id, String name, String description, String path, List<ProjetEntity> projets) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.path = path;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<ProjetEntity> getProjets() {
		return projets;
	}

	public void setProjets(List<ProjetEntity> projets) {
		this.projets = projets;
	}
	
}
