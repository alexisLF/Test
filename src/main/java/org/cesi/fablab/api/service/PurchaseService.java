package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.PurchaseDTO;
import org.cesi.fablab.api.entity.PurchaseEntity;

public interface PurchaseService {
    List<PurchaseDTO> getAllPurchase() throws Exception;

    PurchaseDTO addPurchase(PurchaseDTO dto) throws Exception;

    boolean removePurchase(long id) throws Exception;

    PurchaseEntity updatePurchase(PurchaseDTO dto) throws Exception;

    PurchaseEntity getPurchaseById(long id) throws Exception;

}
