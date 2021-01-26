package org.cesi.fablab.api.repository;

import org.cesi.fablab.api.entity.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(transactionManager = "transactionManager")
public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {

    ResourceEntity findById(long id);
}
