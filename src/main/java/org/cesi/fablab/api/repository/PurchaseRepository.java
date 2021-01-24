package org.cesi.fablab.api.repository;

import org.cesi.fablab.api.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(transactionManager = "transactionManager")
public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {
    PurchaseEntity findById(long id);
}
