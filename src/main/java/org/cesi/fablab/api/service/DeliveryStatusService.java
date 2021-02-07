package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.DeliveryStatusDTO;

public interface DeliveryStatusService {
    List<DeliveryStatusDTO> getAllDeliveryStatus() throws Exception;

    DeliveryStatusDTO addDeliveryStatus(DeliveryStatusDTO dto) throws Exception;

    boolean removeDeliveryStatus(long id) throws Exception;

    DeliveryStatusDTO updateDeliveryStatus(DeliveryStatusDTO dto) throws Exception;

    DeliveryStatusDTO getDeliveryStatusById(long id) throws Exception;

    List<DeliveryStatusDTO> getDeliveryStatusByName(String name) throws Exception;

}
