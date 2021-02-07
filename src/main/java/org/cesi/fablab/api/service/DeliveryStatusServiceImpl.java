package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.DeliveryStatusDTO;
import org.cesi.fablab.api.entity.DeliveryStatusEntity;
import org.cesi.fablab.api.repository.DeliveryStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryStatusServiceImpl implements DeliveryStatusService {
    @Autowired
    private DeliveryStatusRepository deliveryStatusRepository;

    @Override
    public List<DeliveryStatusDTO> getAllDeliveryStatus() throws Exception {
        List<DeliveryStatusDTO> lstDeliveryStatusDTO = new ArrayList<DeliveryStatusDTO>();
        List<DeliveryStatusEntity> lstDeliveryStatusEntity = deliveryStatusRepository.findAll();
        if (lstDeliveryStatusEntity != null && !lstDeliveryStatusEntity.isEmpty()) {
            for (DeliveryStatusEntity currentDeliveryStatusEntity : lstDeliveryStatusEntity) {
                DeliveryStatusDTO deliveryStatusDTO = new DeliveryStatusDTO(currentDeliveryStatusEntity);
                lstDeliveryStatusDTO.add(deliveryStatusDTO);
            }
        }
        return lstDeliveryStatusDTO;
    }

    @Override
    public final DeliveryStatusDTO addDeliveryStatus(final DeliveryStatusDTO dto) throws Exception {
        // TODO Auto-generated method stub
        DeliveryStatusEntity entity = new DeliveryStatusEntity();
        entity.setName(dto.getName());
        deliveryStatusRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public final boolean removeDeliveryStatus(final long id) throws Exception {
        // TODO Auto-generated method stub

        DeliveryStatusEntity entity = deliveryStatusRepository.findById(id);
        if (entity != null) {
            deliveryStatusRepository.delete(entity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final DeliveryStatusDTO updateDeliveryStatus(final DeliveryStatusDTO dto) throws Exception {
        // TODO Auto-generated method stub
        DeliveryStatusEntity entity = deliveryStatusRepository.getOne(dto.getId());
        entity.setName(dto.getName());
        return new DeliveryStatusDTO(deliveryStatusRepository.save(entity));
    }

    @Override
    public final DeliveryStatusDTO getDeliveryStatusById(final long id) throws Exception {
        // TODO Auto-generated method stub
        return new DeliveryStatusDTO(deliveryStatusRepository.getOne(id));
    }

    @Override
    public final List<DeliveryStatusDTO> getDeliveryStatusByName(final String name) throws Exception {
        // TODO Auto-generated method stub
        List<DeliveryStatusDTO> lstDeliveryStatusDTO = new ArrayList<DeliveryStatusDTO>();
        List<DeliveryStatusEntity> lstDeliveryStatusEntity = deliveryStatusRepository.findByName(name);
        if (lstDeliveryStatusEntity != null && !lstDeliveryStatusEntity.isEmpty()) {
            for (DeliveryStatusEntity currentDeliveryStatusEntity : lstDeliveryStatusEntity) {
                DeliveryStatusDTO deliveryStatusDTO = new DeliveryStatusDTO(currentDeliveryStatusEntity);
                lstDeliveryStatusDTO.add(deliveryStatusDTO);
            }
        }
        return lstDeliveryStatusDTO;
    }

}
