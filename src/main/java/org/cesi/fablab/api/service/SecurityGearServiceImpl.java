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
        List<SecurityGearDTO> lstSecurityGearsDTO = new ArrayList<SecurityGearDTO>();
        List<SecurityGearEntity> lstSecurityGearsEntity = securityGearRepository.findAll();
        if (lstSecurityGearsEntity != null && !lstSecurityGearsEntity.isEmpty()) {
            for (SecurityGearEntity currentSecurityGearEntity : lstSecurityGearsEntity) {
                SecurityGearDTO securityGearDTO = new SecurityGearDTO(currentSecurityGearEntity);
                lstSecurityGearsDTO.add(securityGearDTO);
            }
        }
        return lstSecurityGearsDTO;
    }

    @Override
    public final SecurityGearDTO addSecurityGear(final SecurityGearDTO dto) throws Exception {
        // TODO Auto-generated method stub
        SecurityGearEntity entity = new SecurityGearEntity();
        entity.setName(dto.getName());
        securityGearRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removeSecurityGear(final SecurityGearDTO dto) throws Exception {
        // TODO Auto-generated method stub

        SecurityGearEntity entity = securityGearRepository.findById(dto.getId());
        if (entity != null) {
            securityGearRepository.delete(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final SecurityGearEntity updateSecurityGear(final SecurityGearDTO dto) throws Exception {
        // TODO Auto-generated method stub

        SecurityGearEntity entity = this.getSecurityGearById(dto.getId());
        entity.setName(dto.getName());
        return securityGearRepository.save(entity);
    }

    @Override
    public final SecurityGearEntity getSecurityGearById(final long id) throws Exception {
        // TODO Auto-generated method stub

        SecurityGearEntity securityGearEntity = securityGearRepository.getOne(id);
        return securityGearEntity;
    }

}
