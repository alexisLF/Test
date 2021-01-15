package org.cesi.fablab.api.repository;

import org.cesi.fablab.api.entity.SecurityGearEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(transactionManager = "transactionManager")
public interface SecurityGearRepository extends JpaRepository<SecurityGearEntity, Long> {

}
