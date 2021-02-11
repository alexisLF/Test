package org.cesi.fablab.api.dto;

import javax.validation.constraints.NotNull;

import org.cesi.fablab.api.entity.TypeResourceEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeResourceDTO {
    private long id;
    @NotNull
    private String name;

    public TypeResourceDTO(final TypeResourceEntity typeResourceEntity) {
        super();
        this.id = typeResourceEntity.getId();
        this.name = typeResourceEntity.getName();
    }

}
