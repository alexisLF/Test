package org.cesi.fablab.api.repository;

import org.cesi.fablab.api.entity.DocumentationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(transactionManager = "transactionManager")
public interface DocumentationRepository extends JpaRepository<DocumentationEntity, Long> {
    DocumentationEntity findById(long id);
}
