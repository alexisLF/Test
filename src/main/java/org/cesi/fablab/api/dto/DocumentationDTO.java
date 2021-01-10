package org.cesi.fablab.api.dto;

import org.cesi.fablab.api.entity.DocumentationEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentationDTO {
    private int id;
    private String description;
    private String useCondition;
    // private List<ResourceEntity> resourcesList = new ArrayList<ResourceEntity>();
    // private List<FileEntity> filesList = new ArrayList<FileEntity>();

    public DocumentationDTO(final DocumentationEntity documentationEntity) {
        super();
        this.id = documentationEntity.getId();
        this.description = documentationEntity.getDescription();
        this.useCondition = documentationEntity.getUseCondition();
        // this.resourcesList = documentationEntity.getResourcesList();
        // this.filesList = documentationEntity.getFilesList();
    }

}
