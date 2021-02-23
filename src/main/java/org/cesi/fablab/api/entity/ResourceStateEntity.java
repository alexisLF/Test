package org.cesi.fablab.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.cesi.fablab.api.dto.ResourceStateDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resourceState")
public class ResourceStateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(targetEntity = ResourceEntity.class, mappedBy = "state")
    private List<ResourceEntity> resourceList = new ArrayList<ResourceEntity>();

    public ResourceStateEntity(final ResourceStateDTO state) {
        // TODO Auto-generated constructor stub
        super();
        this.id = state.getId();
        this.name = state.getName();
    }

}
