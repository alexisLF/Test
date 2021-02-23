package org.cesi.fablab.api.dto;

import java.util.Calendar;

import javax.validation.constraints.NotNull;

import org.cesi.fablab.api.entity.FileEntity;

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

    public FileDTO(final FileEntity fileEntity) {
        super();
        this.id = fileEntity.getId();
        this.name = fileEntity.getName();
        this.url = fileEntity.getUrl();
        this.dateUpload = fileEntity.getDateUpload();
        this.type = new TypeFileDTO(fileEntity.getType());
    }

    public FileDTO(final String nameRef, final String urlRef) {
        super();
        this.name = nameRef;
        this.url = urlRef;
    }

}
