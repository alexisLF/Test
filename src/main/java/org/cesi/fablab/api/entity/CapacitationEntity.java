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

import org.cesi.fablab.api.dto.CapacitationDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "capacitation")
public class CapacitationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToMany
    @JoinTable(name = "userRoleCapacitation", joinColumns = @JoinColumn(name = "capacitationId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<RoleEntity> rolesList = new ArrayList<RoleEntity>();

    public CapacitationEntity(CapacitationDTO capacitation) {
        // TODO Auto-generated constructor stub
        super();
        this.id = capacitation.getId();
        this.name = capacitation.getName();
        this.description = capacitation.getDescription();
    }
}
