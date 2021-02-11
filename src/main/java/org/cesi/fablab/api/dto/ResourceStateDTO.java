package org.cesi.fablab.api.dto;

import javax.validation.constraints.NotNull;

import org.cesi.fablab.api.entity.ResourceStateEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceStateDTO {
    private long id;
    @NotNull
    private String name;

    public ResourceStateDTO(final ResourceStateEntity resourceStateEntity) {
        super();
        this.id = resourceStateEntity.getId();
        this.name = resourceStateEntity.getName();
    }

}
