package org.example.model.cart;


import org.example.Service.cart.CartService;
import org.example.model.product.Product;

import java.util.List;

public class Cart {
    private final List<CartItem> items;

    public Cart(List<CartItem> items) {
        this.items = items;

    }


    public List<CartItem> getItems() {
        return items;
    }

    public void addToCart(Product product, Float quantity) {
        items.add(new CartItem(product, quantity));
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

}
