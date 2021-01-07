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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "documentation")
public class DocumentationEntity {
// Propriété
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String description;
	@Column
	private String useCondition;

	@OneToMany(targetEntity = ResourceEntity.class, mappedBy = "documentation")
	private List<ResourceEntity> resourcesList = new ArrayList<ResourceEntity>();

	@ManyToMany
	@JoinTable(name = "documentFiles", joinColumns = @JoinColumn(name = "documentId"), inverseJoinColumns = @JoinColumn(name = "fileId"))
	private List<FileEntity> filesList = new ArrayList<FileEntity>();

}
