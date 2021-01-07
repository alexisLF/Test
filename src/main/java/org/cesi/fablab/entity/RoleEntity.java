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


@Entity
@Table(name="userRole")
public class RoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column(name="description", columnDefinition="TEXT")
	private String description;
	
	@OneToMany(targetEntity=UserEntity.class, mappedBy="roleId")
	private List<UserEntity> userList = new ArrayList<UserEntity>();
	
	@ManyToMany
	@JoinTable(name = "userRoleCapacitation", 
	joinColumns = @JoinColumn(name = "roleId" ), 
	inverseJoinColumns = @JoinColumn(name = "capacitationId"))
	private List<CapacitationEntity> CapacitationList = new ArrayList<CapacitationEntity>();
	
	public RoleEntity(int id, String name, String description, List<UserEntity> userList,
			List<CapacitationEntity> capacitationList) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.userList = userList;
		CapacitationList = capacitationList;
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
}
