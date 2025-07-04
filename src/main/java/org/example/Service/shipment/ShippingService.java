package org.example.Service.shipment;

import java.util.List;

public interface ShippingService {
    void startShipping(List<Shippable> items);
}
