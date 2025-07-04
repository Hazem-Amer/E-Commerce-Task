package org.example.utils;

import org.example.model.cart.CartItem;
import org.example.model.product.Product;

import java.util.List;

public class CartValidator {
    public void validate(List<CartItem> items) {
        if (items.isEmpty()) throw new IllegalStateException("Cart is empty.");
        for (CartItem item : items) {
            Product product = item.getProduct();
            if (product.isExpired())
                throw new IllegalStateException(product.getName() + " is expired.");
            if (product.getQuantity() < item.getQuantity())
                throw new IllegalStateException(product.getName() + " is out of stock.");
        }
    }
}
