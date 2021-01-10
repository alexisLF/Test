package org.cesi.fablab.api.dto;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.entity.ResourceEntity;
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
    private int id;
    private String name;
    private List<ResourceEntity> resourceList = new ArrayList<ResourceEntity>();

    public ResourceStateDTO(final ResourceStateEntity resourceStateEntity) {
        super();
        this.id = resourceStateEntity.getId();
        this.name = resourceStateEntity.getName();
        // this.resourceList = resourceStateEntity.getResourceList();
    }

}
