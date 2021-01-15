package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.SecurityGearDTO;

public interface SecurityGearService {

	public List<SecurityGearDTO> getAllSecurityGears() throws Exception;

	public void addSecurityGear(SecurityGearDTO dto) throws Exception;

	public void removeSecurityGear(SecurityGearDTO dto) throws Exception;

	public void updateSecurityGear(SecurityGearDTO dto) throws Exception;

}
