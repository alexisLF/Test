package org.cesi.fablab.api.repository;

import java.util.List;

import org.cesi.fablab.api.entity.TypeOperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(transactionManager = "transactionManager")
public interface TypeOperationRepository extends JpaRepository<TypeOperationEntity, Integer> {
    // @Query("SELECT t FROM Thing t WHERE t.fooIn = ?1")
    List<TypeOperationEntity> findByName(String name);

    TypeOperationEntity findById(int id);
}
