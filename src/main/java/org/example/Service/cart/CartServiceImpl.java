package org.example.Service.cart;

import org.example.model.cart.CartItem;
import org.example.model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {
    private final List<CartItem> items;

    public CartServiceImpl() {
        this.items = new ArrayList<>();
    }

    @Override
    public void addItem(Product product, Double quantity) {
        if (product.getQuantity() < quantity)
            throw new IllegalArgumentException("Requested quantity exceeds available stock.");
        for (CartItem cartItem : items) {
            if (cartItem.getProduct().equals(product)) {
                int index = items.indexOf(cartItem);
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                items.add(index, cartItem);
            }
        }
        items.add(new  CartItem(product, quantity));
    }

    @Override
    public List<CartItem> getItems() {
        return items;
    }



    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
