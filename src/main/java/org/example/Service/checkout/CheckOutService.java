package org.example.Service.checkout;

import org.example.model.cart.Cart;
import org.example.model.Customer;

public interface CheckOutService {
    void checkout(Customer customer, Cart cart);

}
