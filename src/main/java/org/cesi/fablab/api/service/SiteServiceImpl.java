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
    public final SiteDTO addSite(final SiteDTO dto) throws Exception {
        // TODO Auto-generated method stub
        SiteEntity entity = new SiteEntity();
        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        siteRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removeSite(final long id) throws Exception {
        // TODO Auto-generated method stub

        SiteEntity entity = siteRepository.findById(id);
        if (entity != null) {
            siteRepository.delete(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final SiteDTO updateSite(final SiteDTO dto) throws Exception {
        // TODO Auto-generated method stub
        SiteEntity entity = siteRepository.getOne(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        return new SiteDTO(siteRepository.save(entity));
    }

    @Override
    public final SiteDTO getSiteById(final long id) throws Exception {
        // TODO Auto-generated method stub
        return new SiteDTO(siteRepository.getOne(id));
    }

}
