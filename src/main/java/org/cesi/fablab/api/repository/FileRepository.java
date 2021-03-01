package org.cesi.fablab.api.repository;

import java.util.List;

import org.cesi.fablab.api.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(transactionManager = "transactionManager")
public interface FileRepository extends JpaRepository<FileEntity, Long> {
    FileEntity findById(long id);

    @Query("SELECT d.filesList FROM DocumentationEntity d where d.id = :idDocumentation")
    List<FileEntity> findFilesByDocumentationId(long idDocumentation);

    @Query("SELECT d.filesList FROM PurchaseEntity d where d.id = :idPurchase")
    List<FileEntity> findFilesByPurchaseId(long idPurchase);
}
