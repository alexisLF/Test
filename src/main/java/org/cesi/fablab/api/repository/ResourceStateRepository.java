package org.cesi.fablab.api.repository;

import org.cesi.fablab.api.entity.ResourceStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(transactionManager = "transactionManager")
public interface ResourceStateRepository extends JpaRepository<ResourceStateEntity, Long> {

}
