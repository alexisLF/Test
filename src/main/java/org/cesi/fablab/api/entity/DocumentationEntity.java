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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.cesi.fablab.api.dto.DocumentationDTO;
import org.cesi.fablab.api.dto.FileDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "documentation")
public class DocumentationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String description;

    @Column
    private String useCondition;

    @OneToMany(targetEntity = ResourceEntity.class, mappedBy = "documentation")
    private List<ResourceEntity> resourcesList = new ArrayList<ResourceEntity>();

    @ManyToMany
    @JoinTable(name = "documentationFiles", joinColumns = @JoinColumn(name = "documentationId"), inverseJoinColumns = @JoinColumn(name = "fileId"))
    private List<FileEntity> filesList = new ArrayList<FileEntity>();

    public DocumentationEntity(final DocumentationDTO documentation) {
        // TODO Auto-generated constructor stub
        super();
        this.id = documentation.getId();
        this.description = documentation.getDescription();
        this.useCondition = documentation.getUseCondition();
        for (FileDTO entity : documentation.getFilesList()) {
            filesList.add(new FileEntity(entity));
        }
    }
}
