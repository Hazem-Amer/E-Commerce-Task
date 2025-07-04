package org.example.utils;

import org.example.model.cart.CartItem;
import org.example.Service.shipment.Shippable;

import java.util.List;

public class PriceCalculator {
    private static final Float SHIPPING_RATE = 30f;

    public float calculateSubtotal(List<CartItem> items) {
        return (float) items.stream().mapToDouble(CartItem::getSubPrice).sum();
    }

    public Float calculateShipping(List<Shippable> shippables) {
        return shippables.isEmpty() ? 0 : SHIPPING_RATE;
    }
}