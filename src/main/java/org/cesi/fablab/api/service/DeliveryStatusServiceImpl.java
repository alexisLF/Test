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
    public final void addDeliveryStatus(final DeliveryStatusDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public final void removeDeliveryStatus(final DeliveryStatusDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public final void updateDeliveryStatus(final DeliveryStatusDTO dto) throws Exception {
        // TODO Auto-generated method stub

    }

}
