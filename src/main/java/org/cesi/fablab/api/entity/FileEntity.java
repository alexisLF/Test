package org.cesi.fablab.api.entity;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "file")
public class FileEntity {
	// Propriété
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String url;
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Calendar dateUpload;

	@ManyToOne
	@JoinColumn(name = "typeId", nullable = false)
	private TypeFileEntity type;

	@ManyToMany
	@JoinTable(name = "documentationFiles", joinColumns = @JoinColumn(name = "fileId"), inverseJoinColumns = @JoinColumn(name = "documentationId"))
	private List<DocumentationEntity> usersList = new ArrayList<DocumentationEntity>();

	@ManyToMany
	@JoinTable(name = "purchaseFiles", joinColumns = @JoinColumn(name = "fileId"), inverseJoinColumns = @JoinColumn(name = "purchaseId"))
	private List<PurchaseEntity> purchaseFilesList = new ArrayList<PurchaseEntity>();

}
