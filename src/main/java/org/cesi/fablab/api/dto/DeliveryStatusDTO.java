package org.cesi.fablab.api.dto;

import javax.validation.constraints.NotNull;

import org.cesi.fablab.api.entity.DeliveryStatusEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryStatusDTO {
    private long id;
    @NotNull
    private String name;

    public DeliveryStatusDTO(final DeliveryStatusEntity deliveryStatusEntity) {
        super();
        this.id = deliveryStatusEntity.getId();
        this.name = deliveryStatusEntity.getName();
    }

}
