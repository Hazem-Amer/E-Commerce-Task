package org.example.utils;

import org.example.Service.shipment.Shippable;
import org.example.model.cart.CartItem;

import java.util.ArrayList;
import java.util.List;

public class ShippingMapper {
    public List<Shippable> map(List<CartItem> items) {
        List<Shippable> result = new ArrayList<>();

        for (CartItem item : items) {
            if (item.getProduct() instanceof Shippable shippableProduct) {
                Double quantity = item.getQuantity();
                Double unitWeight = shippableProduct.getWeight();
                Double totalWeight = quantity * unitWeight;

                result.add(new Shippable() {
                    @Override
                    public String getShippableName() {
                        return quantity + "x " + item.getProduct().getName();
                    }

                    @Override
                    public Double getWeight() {
                        return totalWeight;
                    }
                });
            }
        }

        return result;
    }
}