package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.PurchaseDTO;

public interface PurchaseService {
    List<PurchaseDTO> getAllPurchase() throws Exception;

    PurchaseDTO addPurchase(PurchaseDTO dto) throws Exception;

    boolean removePurchase(long id) throws Exception;

    PurchaseDTO updatePurchase(PurchaseDTO dto) throws Exception;

    PurchaseDTO getPurchaseById(long id) throws Exception;

}
