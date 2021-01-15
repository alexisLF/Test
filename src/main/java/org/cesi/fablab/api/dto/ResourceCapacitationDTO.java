package org.cesi.fablab.api.dto;

import org.cesi.fablab.api.entity.ResourceCapacitationEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceCapacitationDTO {

    private long id;
    private String name;
    private String description;
    // private List<ResourceEntity> resourceList = new ArrayList<ResourceEntity>();
    // private List<UserEntity> userCapacitationList = new ArrayList<UserEntity>();

    public ResourceCapacitationDTO(final ResourceCapacitationEntity resourceCapacitorEntity) {
        super();
        this.id = resourceCapacitorEntity.getId();
        this.name = resourceCapacitorEntity.getName();
        this.description = resourceCapacitorEntity.getDescription();
        // this.resourceList = resourceCapacitorEntity.getResourceList();
        // this.userCapacitationList =
        // resourceCapacitorEntity.getUserCapacitationList();
    }

}
