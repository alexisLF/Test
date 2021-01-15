package org.cesi.fablab.api.dto;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.entity.ResourceEntity;
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
    private String name;
    private List<ResourceEntity> resourcesList = new ArrayList<ResourceEntity>();

    public TypeResourceDTO(final TypeResourceEntity typeResourceEntity) {
        super();
        this.id = typeResourceEntity.getId();
        this.name = typeResourceEntity.getName();
        // this.resourcesList = typeResourceEntity.getResourcesList();
    }

}
