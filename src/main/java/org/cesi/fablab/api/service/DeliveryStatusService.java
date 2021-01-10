package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.DeliveryStatusDTO;

public interface DeliveryStatusService {
    List<DeliveryStatusDTO> getAllDeliveryStatus() throws Exception;

    void addDeliveryStatus(DeliveryStatusDTO dto) throws Exception;

    void removeDeliveryStatus(DeliveryStatusDTO dto) throws Exception;

    void updateDeliveryStatus(DeliveryStatusDTO dto) throws Exception;

}
