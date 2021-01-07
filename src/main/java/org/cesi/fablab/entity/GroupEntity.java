package org.cesi.fablab.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="userGroup")
public class GroupEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private int site;
	
	@OneToMany(targetEntity=UserEntity.class, mappedBy="groupId")
	private List<UserEntity> userList = new ArrayList<UserEntity>();
	
	public GroupEntity(int id, String name, int site, List<UserEntity> userList) {
		super();
		this.id = id;
		this.name = name;
		this.site = site;
		this.userList = userList;
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

	public int getSite() {
		return site;
	}

	public void setSite(int site) {
		this.site = site;
	}
}
