package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.PurchaseDTO;
import org.cesi.fablab.api.entity.PurchaseEntity;
import org.cesi.fablab.api.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	private PurchaseRepository purchaseRepository;

	@Override
	public List<PurchaseDTO> getAllPurchases() throws Exception {
		List<PurchaseDTO> lstPurchasesDTO = new ArrayList<PurchaseDTO>();
		List<PurchaseEntity> lstPurchasesEntity = purchaseRepository.findAll();
		if (lstPurchasesEntity != null && !lstPurchasesEntity.isEmpty()) {
			for (PurchaseEntity currentPurchaseEntity : lstPurchasesEntity) {
				PurchaseDTO purchaseDTO = new PurchaseDTO(currentPurchaseEntity);
				lstPurchasesDTO.add(purchaseDTO);
			}
		}
		return lstPurchasesDTO;
	}

	@Override
	public final void addPurchase(final PurchaseDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public final void removePurchase(final PurchaseDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public final void updatePurchase(final PurchaseDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

}
