package org.example.model.product;


import org.example.Service.shipment.Shippable;

public class ShippableProducts extends Product implements Shippable {
    private Double weight;

    public ShippableProducts(String name, Float price, Double quantity, Double weight) {
        super(name, price, quantity);
        this.weight = weight;

    }

    @Override
    public String getShippableName() {
        return super.getName();
    }

    @Override
    public Double getWeight() {
        return weight;
    }
}
