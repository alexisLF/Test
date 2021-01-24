package org.cesi.fablab.api.repository;

import java.util.List;

import org.cesi.fablab.api.entity.DeliveryStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(transactionManager = "transactionManager")
public interface DeliveryStatusRepository extends JpaRepository<DeliveryStatusEntity, Long> {
    List<DeliveryStatusEntity> findByName(String name);

    DeliveryStatusEntity findById(long id);
}
