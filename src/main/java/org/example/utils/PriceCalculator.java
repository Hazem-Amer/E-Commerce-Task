package org.example.utils;

import org.example.model.cart.CartItem;
import org.example.Service.shipment.Shippable;

import java.util.List;
import java.util.stream.Stream;

public class PriceCalculator {
    private static final Float SHIPPING_RATE = 30f;

    public float calculateSubtotal(List<CartItem> items) {
        return (float) items.stream().mapToDouble(CartItem::getSubPrice).sum();
    }

    public Float calculateShipping(List<Shippable> shippables) {
        if (shippables == null || shippables.isEmpty()) {
            return 0f;
        } else {
            Float weightSum = getTotalShippableWeight(shippables);
            return weightSum * SHIPPING_RATE;
        }

    }

    private Float getTotalShippableWeight(List<Shippable> shippables) {
        List<Float> shippablesWeight = shippables
                .stream()
                .map(shippable -> shippable.getWeight())
                .toList();
        Float weightSum = 0f;
        for (Float weight : shippablesWeight) {
            weightSum += weight;
        }
        return weightSum;
    }
}