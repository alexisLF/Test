package org.cesi.fablab.api.repository;

import org.cesi.fablab.api.entity.ResourceCapacitationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(transactionManager = "transactionManager")
public interface ResourceCapacitationRepository extends JpaRepository<ResourceCapacitationEntity, Long> {
    ResourceCapacitationEntity findById(long id);
}
