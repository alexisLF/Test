package org.cesi.fablab.api.repository;

import java.util.List;

import org.cesi.fablab.api.entity.MaintenanceStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(transactionManager = "transactionManager")
public interface MaintenanceStatusRepository extends JpaRepository<MaintenanceStatusEntity, Long> {
    List<MaintenanceStatusEntity> findByName(String name);

    MaintenanceStatusEntity findById(long id);
}
