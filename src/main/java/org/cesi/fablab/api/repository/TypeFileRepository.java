package org.cesi.fablab.api.repository;

import org.cesi.fablab.api.entity.TypeFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(transactionManager = "transactionManager")
public interface TypeFileRepository extends JpaRepository<TypeFileEntity, Long> {

    TypeFileEntity findById(long id);
}
