package org.cesi.fablab.api.entity;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private java.util.Calendar dateStart;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Calendar dateEnd;

    @ManyToMany
    @JoinTable(name = "skillProject", joinColumns = @JoinColumn(name = "projetId"), inverseJoinColumns = @JoinColumn(name = "skillId"))
    private List<SkillEntity> skillsList = new ArrayList<SkillEntity>();

    @ManyToMany
    @JoinTable(name = "tagProjet", joinColumns = @JoinColumn(name = "projetId"), inverseJoinColumns = @JoinColumn(name = "tagId"))
    private List<TagEntity> tagsList = new ArrayList<TagEntity>();

    @ManyToMany
    @JoinTable(name = "documentProjet", joinColumns = @JoinColumn(name = "projetId"), inverseJoinColumns = @JoinColumn(name = "documentId"))
    private List<DocumentEntity> documentsList = new ArrayList<DocumentEntity>();

    @ManyToMany
    @JoinTable(name = "resourceProject", joinColumns = @JoinColumn(name = "projectId"), inverseJoinColumns = @JoinColumn(name = "resourceId"))
    private List<ResourceEntity> resourcesList = new ArrayList<ResourceEntity>();

    @ManyToOne
    @JoinColumn(name = "creatorId", nullable = false)
    private UserEntity creator;

    @Column
    private boolean status;

    @Column
    private boolean publicAccess;

    @ManyToMany
    @JoinTable(name = "projectCollaborator", joinColumns = @JoinColumn(name = "projectId"), inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<UserEntity> collaboratorList = new ArrayList<UserEntity>();

}
