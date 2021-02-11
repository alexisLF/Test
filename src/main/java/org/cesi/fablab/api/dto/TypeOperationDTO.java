package org.cesi.fablab.api.dto;

import javax.validation.constraints.NotNull;

import org.cesi.fablab.api.entity.TypeOperationEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeOperationDTO {
    private long id;
    @NotNull
    private String name;
    private String description;

    public TypeOperationDTO(final TypeOperationEntity typeOperationEntity) {
        super();
        this.id = typeOperationEntity.getId();
        this.name = typeOperationEntity.getName();
        this.description = typeOperationEntity.getDescription();
    }

}
