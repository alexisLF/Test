package org.cesi.fablab.api.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.cesi.fablab.api.entity.DocumentationEntity;
import org.cesi.fablab.api.entity.FileEntity;
import org.cesi.fablab.api.entity.PurchaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String url;
    private Calendar dateUpload;
    private TypeFileDTO type;
    private List<DocumentationDTO> documentationsList = new ArrayList<DocumentationDTO>();
    private List<PurchaseDTO> purchaseFilesList = new ArrayList<PurchaseDTO>();

    public FileDTO(final FileEntity fileEntity) {
        super();
        this.id = fileEntity.getId();
        this.name = fileEntity.getName();
        this.url = fileEntity.getUrl();
        this.dateUpload = fileEntity.getDateUpload();
        this.type = new TypeFileDTO(fileEntity.getType());
        this.documentationsList = this.setDocumentationsList(fileEntity.getDocumentationsList());
        this.purchaseFilesList = this.setPurchaseFilesList(fileEntity.getPurchaseFilesList());
    }

    public FileDTO(final FileEntity fileEntity, boolean needType) {
        super();
        this.id = fileEntity.getId();
        this.name = fileEntity.getName();
        this.url = fileEntity.getUrl();
        this.dateUpload = fileEntity.getDateUpload();
        if (needType) {
            this.type = new TypeFileDTO(fileEntity.getType());
        }
        this.documentationsList = this.setDocumentationsList(fileEntity.getDocumentationsList());
        this.purchaseFilesList = this.setPurchaseFilesList(fileEntity.getPurchaseFilesList());
    }

    private List<DocumentationDTO> setDocumentationsList(List<DocumentationEntity> documentations) {
        List<DocumentationDTO> list = new ArrayList<DocumentationDTO>();
        for (DocumentationEntity documentation : documentations) {
            list.add(new DocumentationDTO(documentation));
        }
        return list;
    }

    private List<PurchaseDTO> setPurchaseFilesList(List<PurchaseEntity> purchaseFiles) {
        List<PurchaseDTO> list = new ArrayList<PurchaseDTO>();
        for (PurchaseEntity purchase : purchaseFiles) {
            list.add(new PurchaseDTO(purchase));
        }
        return list;
    }

}
