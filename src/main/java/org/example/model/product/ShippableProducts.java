package org.example.model.product;


import org.example.Service.shipment.Shippable;

import java.time.LocalDate;

public class ShippableProducts extends Product implements Shippable {
    private final Float weight;

    public ShippableProducts(String name, Float price, Float quantity, Float weight) {
        super(name, price, quantity);
        this.weight = weight;

    }

    public ShippableProducts(String name, Float price, Float quantity, LocalDate expiryDate, Boolean isExpirable, Float weight) {
        super(name, price, quantity, expiryDate, isExpirable);
        this.weight = weight;

    }

    @Override
    public String getShippableName() {
        return super.getName();
    }

    @Override
    public Float getWeight() {
        return weight;
    }
}
