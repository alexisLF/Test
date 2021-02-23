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

import org.cesi.fablab.api.dto.TypeResourceDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "typeResource")
public class TypeResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(targetEntity = ResourceEntity.class, mappedBy = "type")
    private List<ResourceEntity> roomsList = new ArrayList<ResourceEntity>();

    public TypeResourceEntity(final TypeResourceDTO type) {
        // TODO Auto-generated constructor stub
        super();
        this.id = type.getId();
        this.name = type.getName();
    }
}
