package org.cesi.fablab.api.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.cesi.fablab.api.entity.DocumentationEntity;
import org.cesi.fablab.api.entity.FileEntity;
import org.cesi.fablab.api.entity.PurchaseEntity;
import org.cesi.fablab.api.entity.TypeFileEntity;

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
    private String name;
    private String url;
    private Calendar dateUpload;
    private TypeFileEntity type;
    private List<DocumentationEntity> usersList = new ArrayList<DocumentationEntity>();
    private List<PurchaseEntity> purchaseFilesList = new ArrayList<PurchaseEntity>();

    public FileDTO(final FileEntity fileEntity) {
        super();
        this.id = fileEntity.getId();
        this.name = fileEntity.getName();
        this.url = fileEntity.getUrl();
        this.dateUpload = fileEntity.getDateUpload();
        // this.type = fileEntity.getType();
        // this.usersList = fileEntity.getUsersList();
        // this.purchaseFilesList = fileEntity.getPurchaseFilesList();
    }

}
