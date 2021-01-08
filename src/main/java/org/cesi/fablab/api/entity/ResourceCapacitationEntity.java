package org.cesi.fablab.api.entity;

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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resourceCapacitation")
public class ResourceCapacitationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@ManyToMany
	@JoinTable(name = "machineCapacitation", joinColumns = @JoinColumn(name = "resourceCapacitationId"), inverseJoinColumns = @JoinColumn(name = "resourceId"))
	private List<ResourceEntity> resourceList = new ArrayList<ResourceEntity>();

	@ManyToMany
	@JoinTable(name = "userCapacitation", joinColumns = @JoinColumn(name = "resourceCapacitationId"), inverseJoinColumns = @JoinColumn(name = "userId"))
	private List<UserEntity> userCapacitationList = new ArrayList<UserEntity>();
}
