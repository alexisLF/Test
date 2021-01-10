package org.cesi.fablab.api.repository;

import org.cesi.fablab.api.entity.CapacitationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(transactionManager = "transactionManager")
public interface CapacitationRepository extends JpaRepository<CapacitationEntity, Long> {

}
