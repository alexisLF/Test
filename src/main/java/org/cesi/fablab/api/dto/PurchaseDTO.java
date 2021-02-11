package org.cesi.fablab.api.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.cesi.fablab.api.entity.DeliveryStatusEntity;
import org.cesi.fablab.api.entity.FileEntity;
import org.cesi.fablab.api.entity.PurchaseEntity;
import org.cesi.fablab.api.entity.ResourceEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {
    private long id;
    @NotNull
    private String name;
    @NotNull
    private Date purchaseDate;
    private ResourceEntity resource;
    private DeliveryStatusEntity delivery;
    private List<FileDTO> filesList = new ArrayList<FileDTO>();

    public PurchaseDTO(final PurchaseEntity purchaseEntity) {
        super();
        this.id = purchaseEntity.getId();
        this.name = purchaseEntity.getName();
        this.purchaseDate = purchaseEntity.getPurchaseDate();
        this.resource = purchaseEntity.getResource();
        this.delivery = purchaseEntity.getDelivery();
        for (FileEntity entity : purchaseEntity.getFilesList()) {
            filesList.add(new FileDTO(entity));
        }

    }

}
