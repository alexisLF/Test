package org.cesi.fablab.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "site")
public class SiteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @OneToMany(targetEntity = HolidayEntity.class, mappedBy = "site")
    private List<HolidayEntity> holidaysList = new ArrayList<HolidayEntity>();

    @OneToMany(targetEntity = RoomEntity.class, mappedBy = "site", cascade = CascadeType.REMOVE)
    private List<RoomEntity> roomsList = new ArrayList<RoomEntity>();
}
