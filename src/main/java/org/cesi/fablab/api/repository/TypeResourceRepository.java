package org.cesi.fablab.api.repository;

import java.util.List;

import org.cesi.fablab.api.entity.TypeResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(transactionManager = "transactionManager")
public interface TypeResourceRepository extends JpaRepository<TypeResourceEntity, Long> {
    List<TypeResourceEntity> findByName(String name);

    TypeResourceEntity findById(long id);
}
