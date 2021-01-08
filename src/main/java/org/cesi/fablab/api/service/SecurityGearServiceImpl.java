package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.SecurityGearDTO;
import org.cesi.fablab.api.entity.SecurityGearEntity;
import org.cesi.fablab.api.repository.SecurityGearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityGearServiceImpl implements SecurityGearService {

	@Autowired
	private SecurityGearRepository securityGearRepository;

	@Override
	public List<SecurityGearDTO> getAllSecurityGears() throws Exception {
		List<SecurityGearDTO> lstSecurityGearDTO = new ArrayList<SecurityGearDTO>();
		List<SecurityGearEntity> lstSecurityGearsEntity = securityGearRepository.findAll();
		if (lstSecurityGearsEntity != null && !lstSecurityGearsEntity.isEmpty()) {
			for (SecurityGearEntity currentSecurityGearEntity : lstSecurityGearsEntity) {
				SecurityGearDTO securityGearDTO = new SecurityGearDTO(currentSecurityGearEntity);
				lstSecurityGearDTO.add(securityGearDTO);
			}
		}
		return lstSecurityGearDTO;
	}

	@Override
	public void addSecurityGear(SecurityGearDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeSecurityGear(SecurityGearDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSecurityGear(SecurityGearDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

}
