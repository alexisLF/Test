package org.cesi.fablab.api.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.entity.FileEntity;
import org.cesi.fablab.api.entity.DeliveryStatusEntity;
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
	private int id;
	private String name;
	private Date purchaseDate;
	private ResourceEntity ressource;
	private DeliveryStatusEntity delivery;
	private List<FileEntity> filesList = new ArrayList<FileEntity>();

	public PurchaseDTO(final PurchaseEntity purchaseEntity) {
		super();
		this.id = purchaseEntity.getId();
		this.name = purchaseEntity.getName();
		this.purchaseDate = purchaseEntity.getPurchaseDate();
		// this.ressource = userEntity.getRessource();
		// this.delivery = userEntity.getDelivery();
		// this.filesList = userEntity.getFilesList();
	}

}
