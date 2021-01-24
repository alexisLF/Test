package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.PurchaseDTO;
import org.cesi.fablab.api.entity.DeliveryStatusEntity;
import org.cesi.fablab.api.entity.PurchaseEntity;
import org.cesi.fablab.api.entity.ResourceEntity;
import org.cesi.fablab.api.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public List<PurchaseDTO> getAllPurchase() throws Exception {
        List<PurchaseDTO> lstPurchasesDTO = new ArrayList<PurchaseDTO>();
        List<PurchaseEntity> lstPurchasesEntity = purchaseRepository.findAll();
        if (lstPurchasesEntity != null && !lstPurchasesEntity.isEmpty()) {
            for (PurchaseEntity currentPurchaseEntity : lstPurchasesEntity) {
                PurchaseDTO purchaseDTO = new PurchaseDTO(currentPurchaseEntity);
                ResourceEntity resource = new ResourceEntity();
                resource.setId(currentPurchaseEntity.getResource().getId());
                purchaseDTO.setResource(resource);
                DeliveryStatusEntity deliveryStatus = new DeliveryStatusEntity();
                deliveryStatus.setId(currentPurchaseEntity.getDelivery().getId());
                purchaseDTO.setDelivery(deliveryStatus);
                lstPurchasesDTO.add(purchaseDTO);
            }
        }
        return lstPurchasesDTO;
    }

    @Override
    public final PurchaseDTO addPurchase(final PurchaseDTO dto) throws Exception {
        // TODO Auto-generated method stub
        PurchaseEntity entity = new PurchaseEntity();
        entity.setName(dto.getName());
        entity.setPurchaseDate(dto.getPurchaseDate());
        ResourceEntity resource = new ResourceEntity();
        resource.setId(dto.getResource().getId());
        entity.setResource(resource);
        DeliveryStatusEntity deliveryStatus = new DeliveryStatusEntity();
        deliveryStatus.setId(dto.getDelivery().getId());
        entity.setDelivery(deliveryStatus);
        purchaseRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removePurchase(final long id) throws Exception {
        // TODO Auto-generated method stub

        PurchaseEntity entity = purchaseRepository.findById(id);
        if (entity != null) {
            purchaseRepository.delete(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final PurchaseEntity updatePurchase(final PurchaseDTO dto) throws Exception {
        // TODO Auto-generated method stub
        PurchaseEntity entity = this.getPurchaseById(dto.getId());
        entity.setName(dto.getName());
        entity.setPurchaseDate(dto.getPurchaseDate());
        ResourceEntity resource = new ResourceEntity();
        resource.setId(dto.getResource().getId());
        entity.setResource(resource);
        DeliveryStatusEntity deliveryStatus = new DeliveryStatusEntity();
        deliveryStatus.setId(dto.getDelivery().getId());
        entity.setDelivery(deliveryStatus);
        return purchaseRepository.save(entity);
    }

    @Override
    public final PurchaseEntity getPurchaseById(final long id) throws Exception {
        // TODO Auto-generated method stub
        PurchaseEntity entity = purchaseRepository.getOne(id);
        ResourceEntity resource = new ResourceEntity();
        resource.setId(entity.getResource().getId());
        entity.setResource(resource);
        DeliveryStatusEntity deliveryStatus = new DeliveryStatusEntity();
        deliveryStatus.setId(entity.getDelivery().getId());
        entity.setDelivery(deliveryStatus);
        return entity;
    }

}
