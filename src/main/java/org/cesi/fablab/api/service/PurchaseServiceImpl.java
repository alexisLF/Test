package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.cesi.fablab.api.dto.FileDTO;
import org.cesi.fablab.api.dto.PurchaseDTO;
import org.cesi.fablab.api.entity.DeliveryStatusEntity;
import org.cesi.fablab.api.entity.FileEntity;
import org.cesi.fablab.api.entity.PurchaseEntity;
import org.cesi.fablab.api.entity.ResourceEntity;
import org.cesi.fablab.api.entity.TypeFileEntity;
import org.cesi.fablab.api.repository.FileRepository;
import org.cesi.fablab.api.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private FileRepository fileRepository;

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

        TypeFileEntity type = new TypeFileEntity();
        type.setId(1);
        List<PurchaseEntity> purchaseEntity = new ArrayList<PurchaseEntity>();
        purchaseEntity.add(entity);

        List<FileDTO> lstFilesDTO = dto.getFilesList();
        for (FileDTO currentFileDTO : lstFilesDTO) {
            FileEntity currentFileEntity = new FileEntity();
            currentFileEntity.setName(currentFileDTO.getName());
            currentFileEntity.setUrl(currentFileDTO.getUrl());
            currentFileEntity.setDateUpload(Calendar.getInstance());
            currentFileEntity.setType(type);
            currentFileEntity.setPurchaseFilesList(purchaseEntity);
            fileRepository.save(currentFileEntity);
        }

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
    public final PurchaseDTO updatePurchase(final PurchaseDTO dto) throws Exception {
        // TODO Auto-generated method stub
        PurchaseEntity entity = purchaseRepository.getOne(dto.getId());
        entity.setName(dto.getName());
        entity.setPurchaseDate(dto.getPurchaseDate());
        ResourceEntity resource = new ResourceEntity();
        resource.setId(dto.getResource().getId());
        entity.setResource(resource);
        DeliveryStatusEntity deliveryStatus = new DeliveryStatusEntity();
        deliveryStatus.setId(dto.getDelivery().getId());
        entity.setDelivery(deliveryStatus);
        purchaseRepository.save(entity);

        TypeFileEntity type = new TypeFileEntity();
        type.setId(1);
        List<PurchaseEntity> purchaseEntity = new ArrayList<PurchaseEntity>();
        purchaseEntity.add(entity);

        List<FileDTO> lstFilesDTO = dto.getFilesList();
        for (FileDTO currentFileDTO : lstFilesDTO) {
            FileEntity currentFileEntity = new FileEntity();
            currentFileEntity.setName(currentFileDTO.getName());
            currentFileEntity.setUrl(currentFileDTO.getUrl());
            currentFileEntity.setDateUpload(Calendar.getInstance());
            currentFileEntity.setType(type);
            currentFileEntity.setPurchaseFilesList(purchaseEntity);
            fileRepository.save(currentFileEntity);
        }

        return new PurchaseDTO(purchaseRepository.save(entity));
    }

    @Override
    public final PurchaseDTO getPurchaseById(final long id) throws Exception {
        // TODO Auto-generated method stub
        PurchaseEntity entity = purchaseRepository.getOne(id);
        ResourceEntity resource = new ResourceEntity();
        resource.setId(entity.getResource().getId());
        entity.setResource(resource);
        DeliveryStatusEntity deliveryStatus = new DeliveryStatusEntity();
        deliveryStatus.setId(entity.getDelivery().getId());
        entity.setDelivery(deliveryStatus);
        return new PurchaseDTO(entity);
    }

}
