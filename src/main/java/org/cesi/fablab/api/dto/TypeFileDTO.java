package org.cesi.fablab.api.dto;

import javax.validation.constraints.NotNull;

import org.cesi.fablab.api.entity.TypeFileEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeFileDTO {
    private long id;
    @NotNull
    private String name;

    public TypeFileDTO(final TypeFileEntity typeFileEntity) {
        super();
        this.id = typeFileEntity.getId();
        this.name = typeFileEntity.getName();
    }

}
