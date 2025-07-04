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


    private EcommerceStore() {
        CartService cartService = new CartServiceImpl();
        ShippingService shippingService = new ShippingServiceImpl();
        CheckOutService checkoutService = new Checkout(cartService,shippingService);
        Cart cart = new Cart(cartService);

        /*Works normal Use Case*/
        Customer customer = new Customer("Hazem", 10000f);
        Product cheese = new ShippableProducts("Cheese", 100f, 5f, LocalDate.now(),true ,1f);
        Product tv = new ShippableProducts("TV", 200f, 3f,5f);

        cart.addToCart(cheese, 2f);
        cart.addToCart(tv, 1f);
        checkoutService.checkout(customer,cart);

        /*Throws product expired exception*/
//        Product expiredMilk = new Product("Milk", 50f, 2d, LocalDate.now().minusDays(1), true);
//        Customer sami = new Customer("Sami", 500f);
//
//        cart.addToCart(expiredMilk, 1d);
//        checkoutService.checkout(sami, cart);




       /*Throws product outofstock exception*/
//        Product biscuits = new Product("Biscuits", 80f, 1d, LocalDate.now().plusDays(3), true);
//        Customer alaa = new Customer("Alaa", 400f);
//
//        cart.addToCart(biscuits, 3d);
//        checkoutService.checkout(alaa, cart);


        /*insufficient Balance exception*/
//        Product laptop = new ShippableProducts("Laptop", 900f, 2d, 2d);
//        Customer omar = new Customer("Omar", 500f); // not enough for Laptop
//
//        cart.addToCart(laptop, 1d);
//        checkoutService.checkout(omar, cart);


        /*Empty Cart exception*/
//        Customer nour = new Customer("Nour", 500f);
//        checkoutService.checkout(nour, cart);



    }


}
