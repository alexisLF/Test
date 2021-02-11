package org.cesi.fablab.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.cesi.fablab.api.dto.RoomDTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String floor;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "siteId", nullable = false)
    private SiteEntity site;

    @JsonBackReference
    @OneToMany(targetEntity = ResourceEntity.class, mappedBy = "room")
    private List<ResourceEntity> resourcesList = new ArrayList<ResourceEntity>();

    public RoomEntity(RoomDTO room) {
        // TODO Auto-generated constructor stub
        super();
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.site = room.getSite();
    }

}
