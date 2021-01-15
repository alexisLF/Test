package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.SiteDTO;

public interface SiteService {
	public List<SiteDTO> getAllSites() throws Exception;

	public void addSite(SiteDTO dto) throws Exception;

	public void removeSite(SiteDTO dto) throws Exception;

	public void updateSite(SiteDTO dto) throws Exception;

}
