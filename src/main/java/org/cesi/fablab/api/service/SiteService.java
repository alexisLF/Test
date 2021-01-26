package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.SiteDTO;
import org.cesi.fablab.api.entity.SiteEntity;

public interface SiteService {
    List<SiteDTO> getAllSites() throws Exception;

    SiteDTO addSite(SiteDTO dto) throws Exception;

    boolean removeSite(long id) throws Exception;

    SiteEntity updateSite(SiteDTO dto) throws Exception;

    SiteEntity getSiteById(long id) throws Exception;

}
