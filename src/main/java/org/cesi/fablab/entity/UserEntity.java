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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String mail;
	@Column
	private String password;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private boolean active;
	@Column(name = "date_active")
	private LocalDateTime dateActive;
	@Column
	private String avatar;
	@Column
	private int credit;
	
	@ManyToOne
	@JoinColumn(name="group_id", nullable=false)
	private GroupEntity groupId;
	
	@ManyToOne
	@JoinColumn(name="role_id", nullable=false)
	private RoleEntity roleId;
	
	@OneToMany( targetEntity=ReservationEntity.class, mappedBy="userId" )
    private List<ReservationEntity> reservationList = new ArrayList<ReservationEntity>();
	
	@OneToMany( targetEntity=ProjectEntity.class, mappedBy="creatorId" )
    private List<ProjectEntity> projectCollaboratorList = new ArrayList<ProjectEntity>();
	
	@ManyToMany
	@JoinTable( name= "projectCollaborator",
				joinColumns = @JoinColumn(name="userId"),
				inverseJoinColumns = @JoinColumn( name = "projectId"))
	private List<UserEntity> projectList = new ArrayList<UserEntity>();
	
	

	public UserEntity(int id, String mail, String password, String firstname, String lastname, boolean active,
			LocalDateTime dateActive, String avatar, int credit, GroupEntity groupId, RoleEntity roleId,
			List<ReservationEntity> reservationList, List<ProjectEntity> projectCollaboratorList,
			List<UserEntity> projectList) {
		super();
		this.id = id;
		this.mail = mail;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.active = active;
		this.dateActive = dateActive;
		this.avatar = avatar;
		this.credit = credit;
		this.groupId = groupId;
		this.roleId = roleId;
		this.reservationList = reservationList;
		this.projectCollaboratorList = projectCollaboratorList;
		this.projectList = projectList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime getDateActive() {
		return dateActive;
	}

	public void setDateActive(LocalDateTime dateActive) {
		this.dateActive = dateActive;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public GroupEntity getGroupId() {
		return groupId;
	}

	public void setGroupId(GroupEntity groupId) {
		this.groupId = groupId;
	}

	public RoleEntity getRoleId() {
		return roleId;
	}

	public void setRoleId(RoleEntity roleId) {
		this.roleId = roleId;
	}

	public List<ReservationEntity> getReservationList() {
		return reservationList;
	}

	public void setReservationList(List<ReservationEntity> reservationList) {
		this.reservationList = reservationList;
	}

	public List<ProjectEntity> getProjectCollaboratorList() {
		return projectCollaboratorList;
	}

	public void setProjectCollaboratorList(List<ProjectEntity> projectCollaboratorList) {
		this.projectCollaboratorList = projectCollaboratorList;
	}

	public List<UserEntity> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<UserEntity> projectList) {
		this.projectList = projectList;
	}
	
	
}
