package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.PurchaseDTO;

public interface PurchaseService {
    List<PurchaseDTO> getAllPurchases() throws Exception;

    void addPurchase(PurchaseDTO dto) throws Exception;

    void removePurchase(PurchaseDTO dto) throws Exception;

    void updatePurchase(PurchaseDTO dto) throws Exception;

}
