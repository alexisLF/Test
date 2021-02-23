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

import org.cesi.fablab.api.dto.SecurityGearDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "securitygear")
public class SecurityGearEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "resourceSecurityGear", joinColumns = @JoinColumn(name = "securityGearId"), inverseJoinColumns = @JoinColumn(name = "resourceId"))
    private List<ResourceEntity> resourcesList = new ArrayList<ResourceEntity>();

    public SecurityGearEntity(final SecurityGearDTO securityGear) {
        // TODO Auto-generated constructor stub
        super();
        this.id = securityGear.getId();
        this.name = securityGear.getName();
    }
}
