package org.example.model.cart;


import org.example.Service.cart.CartService;
import org.example.model.product.Product;

import java.util.List;

public class Cart {
    private final CartService cartService;

    public Cart(CartService cartService) {
        this.cartService = cartService;

    }


    public List<CartItem> getItems() {
        return cartService.getItems();
    }

    public void addToCart(Product product, Float quantity) {
        cartService.addItem(product, quantity);
    }

    public boolean isEmpty() {
        return cartService.getItems().isEmpty();
    }

}
