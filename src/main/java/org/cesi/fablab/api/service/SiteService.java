package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.SiteDTO;

public interface SiteService {
    List<SiteDTO> getAllSites() throws Exception;

    SiteDTO addSite(SiteDTO dto) throws Exception;

    boolean removeSite(long id) throws Exception;

    SiteDTO updateSite(SiteDTO dto) throws Exception;

    SiteDTO getSiteById(long id) throws Exception;

}
