package org.cesi.fablab.entity;

import java.time.LocalDateTime;
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
}
