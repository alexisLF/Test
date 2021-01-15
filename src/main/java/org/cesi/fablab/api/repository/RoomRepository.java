package org.cesi.fablab.api.repository;

import java.util.List;

import org.cesi.fablab.api.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(transactionManager = "transactionManager")
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    RoomEntity findById(long id);

    List<RoomEntity> findBySite(long idSite);
}
