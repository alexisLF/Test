package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.ResourceDTO;

public interface ResourceService {
	List<ResourceDTO> getAllResources() throws Exception;

	void addResource(ResourceDTO dto) throws Exception;

	void removeResource(ResourceDTO dto) throws Exception;

	void updateResource(ResourceDTO dto) throws Exception;

}
