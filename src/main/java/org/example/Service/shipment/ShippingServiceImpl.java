package org.example.Service.shipment;

import java.util.List;

public class ShippingServiceImpl implements ShippingService {
    @Override
    public void startShipping(List<Shippable> products) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Shippable product : products) {
            System.out.println(product.getShippableName());
            totalWeight += product.getWeight();
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
