package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.SecurityGearDTO;

public interface SecurityGearService {

    List<SecurityGearDTO> getAllSecurityGears() throws Exception;

    SecurityGearDTO addSecurityGear(SecurityGearDTO dto) throws Exception;

    boolean removeSecurityGear(long id) throws Exception;

    SecurityGearDTO updateSecurityGear(SecurityGearDTO dto) throws Exception;

    SecurityGearDTO getSecurityGearById(long id) throws Exception;

}
