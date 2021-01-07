package org.cesi.fablab.entity;

import java.sql.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "resource")
public class ResourceEntity {
	//Propriété
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String ref;
	@Basic
	private java.sql.Date dateInstallation;
	@Column
	private int Stock;
	@Column
	private Boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="typeId", nullable = false)
	private TypeResource type;
	
	@ManyToOne
	@JoinColumn(name="roomId", nullable = false)
	private RoomEntity room;
	
	@ManyToOne
	@JoinColumn(name="stateId", nullable = false)
	private ResourceStateEntity state;
	
	@OneToMany( targetEntity=ConsumableEntity.class, mappedBy="resource" )
    private List<ConsumableEntity> consumableList = new ArrayList<ConsumableEntity>();
		
	@ManyToOne
	@JoinColumn(name="documentationId", nullable = false)
	private DocumentationEntity documentation;
	
	
	@ManyToMany
    @JoinTable( name = "documentFiles",
                joinColumns = @JoinColumn( name = "resourceId" ),
                inverseJoinColumns = @JoinColumn( name = "securityGearId" ) )
    private List<ResourceEntity> resource = new ArrayList<ResourceEntity>();
	
	@ManyToMany
	@JoinTable( name= "resourceProject",
				joinColumns = @JoinColumn(name="resourceId"),
				inverseJoinColumns = @JoinColumn( name = "projectId"))
	private List<ResourceEntity> resourceList = new ArrayList<ResourceEntity>();
	
	@OneToMany( targetEntity=ReservationEntity.class, mappedBy="resourceId" )
    private List<ReservationEntity> reservationList = new ArrayList<ReservationEntity>();
	
	//Constructeur
	public ResourceEntity(int id, String name, String ref, Date dateInstallation, int stock, Boolean isActive,
			TypeResource type, RoomEntity room, ResourceStateEntity state, List<ConsumableEntity> consumableList) {
		super();
		this.id = id;
		this.name = name;
		this.ref = ref;
		this.dateInstallation = dateInstallation;
		Stock = stock;
		this.isActive = isActive;
		this.type = type;
		this.room = room;
		this.state = state;
		this.consumableList = consumableList;
	}
	
	//Méthode

	public int getId() {
		return id;
	}
	
	
	public TypeResource getType() {
		return type;
	}

	public void setType(TypeResource type) {
		this.type = type;
	}

	public RoomEntity getRoom() {
		return room;
	}

	public void setRoom(RoomEntity room) {
		this.room = room;
	}

	public ResourceStateEntity getState() {
		return state;
	}

	public void setState(ResourceStateEntity state) {
		this.state = state;
	}

	public List<ConsumableEntity> getConsumableList() {
		return consumableList;
	}

	public void setConsumableList(List<ConsumableEntity> consumableList) {
		this.consumableList = consumableList;
	}

	public DocumentationEntity getDocumentation() {
		return documentation;
	}

	public void setDocumentation(DocumentationEntity documentation) {
		this.documentation = documentation;
	}

	public List<ResourceEntity> getResource() {
		return resource;
	}

	public void setResource(List<ResourceEntity> resource) {
		this.resource = resource;
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
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public java.sql.Date getDateInstallation() {
		return dateInstallation;
	}
	public void setDateInstallation(java.sql.Date dateInstallation) {
		this.dateInstallation = dateInstallation;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	
}
