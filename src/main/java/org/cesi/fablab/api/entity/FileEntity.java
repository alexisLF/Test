package org.cesi.fablab.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.cesi.fablab.api.dto.FileDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "file")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String url;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Calendar dateUpload;

    @ManyToOne
    @JoinColumn(name = "typeId", nullable = false)
    private TypeFileEntity type;

    @ManyToMany
    @JoinTable(name = "documentationFiles", joinColumns = @JoinColumn(name = "fileId"), inverseJoinColumns = @JoinColumn(name = "documentationId"))
    private List<DocumentationEntity> documentationsList = new ArrayList<DocumentationEntity>();

    @ManyToMany
    @JoinTable(name = "purchaseFiles", joinColumns = @JoinColumn(name = "fileId"), inverseJoinColumns = @JoinColumn(name = "purchaseId"))
    private List<PurchaseEntity> purchaseFilesList = new ArrayList<PurchaseEntity>();

    public FileEntity(FileDTO file) {
        // TODO Auto-generated constructor stub
        super();
        this.id = file.getId();
        this.name = file.getName();
        this.url = file.getUrl();
        this.dateUpload = file.getDateUpload();
        this.type = new TypeFileEntity(file.getType());
    }
}
