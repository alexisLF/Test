package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.SecurityGearDTO;
import org.cesi.fablab.api.entity.SecurityGearEntity;

public interface SecurityGearService {

    List<SecurityGearDTO> getAllSecurityGears() throws Exception;

    SecurityGearDTO addSecurityGear(SecurityGearDTO dto) throws Exception;

    boolean removeSecurityGear(SecurityGearDTO dto) throws Exception;

    SecurityGearEntity updateSecurityGear(SecurityGearDTO dto) throws Exception;

    SecurityGearEntity getSecurityGearById(long id) throws Exception;

}
