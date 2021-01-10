package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.FileDTO;
import org.cesi.fablab.api.entity.FileEntity;
import org.cesi.fablab.api.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
	@Autowired
	private FileRepository fileRepository;

	@Override
	public List<FileDTO> getAllFiles() throws Exception {
		List<FileDTO> lstFilesDTO = new ArrayList<FileDTO>();
		List<FileEntity> lstFilesEntity = fileRepository.findAll();
		if (lstFilesEntity != null && !lstFilesEntity.isEmpty()) {
			for (FileEntity currentFileEntity : lstFilesEntity) {
				FileDTO fileDTO = new FileDTO(currentFileEntity);
				lstFilesDTO.add(fileDTO);
			}
		}
		return lstFilesDTO;
	}

	@Override
	public final void addFile(final FileDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public final void removeFile(final FileDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public final void updateFile(final FileDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

}
