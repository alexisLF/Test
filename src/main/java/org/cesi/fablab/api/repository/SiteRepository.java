package org.cesi.fablab.api.repository;

import org.cesi.fablab.api.entity.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(transactionManager = "transactionManager")
public interface SiteRepository extends JpaRepository<SiteEntity, Long> {
    SiteEntity findById(long id);
}
