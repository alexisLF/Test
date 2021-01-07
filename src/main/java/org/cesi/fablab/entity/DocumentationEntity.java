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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "documentation")
public class DocumentationEntity {
	//Propriété
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String description;
	@Column
	private String useCondition;
	
	@OneToMany( targetEntity=ResourceEntity.class, mappedBy="documentation" )
    private List<ResourceEntity> resourceList = new ArrayList<ResourceEntity>();
	
	@ManyToMany
    @JoinTable( name = "documentFiles",
                joinColumns = @JoinColumn( name = "documentId" ),
                inverseJoinColumns = @JoinColumn( name = "fileId" ) )
    private List<FileEntity> files = new ArrayList<FileEntity>();

	//Constructeur
	public DocumentationEntity(int id, String description, String useCondition, List<ResourceEntity> resourceId,
			List<FileEntity> files) {
		super();
		this.id = id;
		this.description = description;
		this.useCondition = useCondition;
		this.resourceList = resourceId;
		this.files = files;
	}

	
	//Methode 
	
	public int getId() {
		return id;
	}
	
	public List<ResourceEntity> getResourceList() {
		return resourceList;
	}


	public void setResourceList(List<ResourceEntity> resourceList) {
		this.resourceList = resourceList;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUseCondition() {
		return useCondition;
	}

	public void setUseCondition(String useCondition) {
		this.useCondition = useCondition;
	}

	public List<ResourceEntity> getResourceId() {
		return resourceList;
	}

	public void setResourceId(List<ResourceEntity> resourceList) {
		this.resourceList = resourceList;
	}

	public List<FileEntity> getFiles() {
		return files;
	}

	public void setFiles(List<FileEntity> files) {
		this.files = files;
	}
	
	
}
