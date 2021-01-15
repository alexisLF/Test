package org.cesi.fablab.api.dto;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.entity.DeliveryStatusEntity;
import org.cesi.fablab.api.entity.PurchaseEntity;

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
    private String name;
    private List<PurchaseEntity> purchasesList = new ArrayList<PurchaseEntity>();

    public DeliveryStatusDTO(final DeliveryStatusEntity deliveryStatusEntity) {
        super();
        this.id = deliveryStatusEntity.getId();
        this.name = deliveryStatusEntity.getName();
        // this.purchasesList = deliveryStatusEntity.getPurchasesList();
    }

}
