package org.example;

import org.example.Service.cart.CartService;
import org.example.Service.cart.CartServiceImpl;
import org.example.Service.checkout.CheckOutService;
import org.example.Service.checkout.Checkout;
import org.example.Service.shipment.ShippingService;
import org.example.Service.shipment.ShippingServiceImpl;
import org.example.model.Customer;
import org.example.model.cart.Cart;
import org.example.model.product.Product;
import org.example.model.product.ShippableProducts;

import java.time.LocalDate;


public class EcommerceStore {
    private static volatile EcommerceStore ecommerceStore = null;
    private CartService cartService;

    private EcommerceStore() {
        Product cheese = new Product("Cheese", 100f, 5d, LocalDate.now(),true );
        Product milk = new Product("Cheese", 100f, 5d,LocalDate.now().plusDays(2),true );
        Product tv = new ShippableProducts("TV", 200f, 3d,2d);

        Customer customer = new Customer("Hazem", 10000f);
        cartService = new CartServiceImpl();
        Cart cart = new Cart(cartService);
        cart.addToCart(cheese, 2d);
        cart.addToCart(milk, 3.5d);
        cart.addToCart(tv, 1d);

        ShippingService shippingService = new ShippingServiceImpl();
        CheckOutService checkoutService = new Checkout(cartService,shippingService);
        checkoutService.checkout(customer,cart);
    }

    public static EcommerceStore getEcommerceStore() {
        if (ecommerceStore == null) {
            synchronized (EcommerceStore.class) {
                if (ecommerceStore == null) {
                    ecommerceStore = new EcommerceStore();
                }
            }
        }
        return ecommerceStore;
    }
}
