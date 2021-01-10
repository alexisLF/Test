package org.cesi.fablab.api.dto;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.entity.FileEntity;
import org.cesi.fablab.api.entity.TypeFileEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeFileDTO {
	private int id;
	private String name;
	private List<FileEntity> filesList = new ArrayList<FileEntity>();

	public TypeFileDTO(final TypeFileEntity typeFileEntity) {
		super();
		this.id = typeFileEntity.getId();
		this.name = typeFileEntity.getName();
		// this.filesList = typeFileEntity.getFilesList();
	}

}
