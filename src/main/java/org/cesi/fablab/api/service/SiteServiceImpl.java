package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.SiteDTO;
import org.cesi.fablab.api.entity.SiteEntity;
import org.cesi.fablab.api.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteServiceImpl implements SiteService {
	@Autowired
	private SiteRepository siteRepository;

	@Override
	public List<SiteDTO> getAllSites() throws Exception {
		List<SiteDTO> lstSitesDTO = new ArrayList<SiteDTO>();
		List<SiteEntity> lstSitesEntity = siteRepository.findAll();
		if (lstSitesEntity != null && !lstSitesEntity.isEmpty()) {
			for (SiteEntity currentSiteEntity : lstSitesEntity) {
				SiteDTO siteDTO = new SiteDTO(currentSiteEntity);
				lstSitesDTO.add(siteDTO);
			}
		}
		return lstSitesDTO;
	}

	@Override
	public void addSite(SiteDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeSite(SiteDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSite(SiteDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

}
