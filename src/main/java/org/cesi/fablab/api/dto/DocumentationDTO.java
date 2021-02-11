package org.cesi.fablab.api.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.cesi.fablab.api.entity.DocumentationEntity;
import org.cesi.fablab.api.entity.FileEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentationDTO {
    private long id;
    @NotNull
    private String description;
    private String useCondition;
    private List<FileDTO> filesList = new ArrayList<FileDTO>();

    public DocumentationDTO(final DocumentationEntity documentationEntity) {
        super();
        this.id = documentationEntity.getId();
        this.description = documentationEntity.getDescription();
        this.useCondition = documentationEntity.getUseCondition();
        for (FileEntity entity : documentationEntity.getFilesList()) {
            filesList.add(new FileDTO(entity));
        }

    }

}
