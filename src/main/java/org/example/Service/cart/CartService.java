package org.example.Service.cart;

import org.example.model.cart.CartItem;
import org.example.model.product.Product;

import java.util.List;

public interface CartService {
    void addItem(Product product , Double quantity);
    List<CartItem> getItems();
    boolean isEmpty();

}
