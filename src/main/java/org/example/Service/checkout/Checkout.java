package org.example.Service.checkout;

import org.example.Service.cart.CartService;
import org.example.Service.shipment.ShippingService;
import org.example.Service.shipment.ShippingServiceImpl;
import org.example.utils.ReceiptPrinter;
import org.example.model.cart.Cart;
import org.example.model.cart.CartItem;
import org.example.model.Customer;
import org.example.utils.CartValidator;
import org.example.utils.PriceCalculator;
import org.example.Service.shipment.Shippable;
import org.example.utils.ShippingMapper;

import java.util.List;

public class Checkout implements CheckOutService {
    private final ShippingService shippingService;
    private final CartService cartService;
    private final CartValidator validator;
    private final ReceiptPrinter receiptPrinter;
    private final PriceCalculator priceCalculator;
    private final ShippingMapper shippingMapper;

    public Checkout(CartService cartService,ShippingService shippingService) {
        this.cartService = cartService;
        this.shippingService = new ShippingServiceImpl();
        this.validator = new CartValidator();
        this.receiptPrinter = new ReceiptPrinter();
        this.priceCalculator = new PriceCalculator();
        this.shippingMapper = new ShippingMapper();
    }


    @Override
    public void checkout(Customer customer, Cart cart) {
        if (cartService.isEmpty()) throw new IllegalStateException("Cart is empty.");
        List<CartItem> items = cartService.getItems();
        validator.validate(items);
        List<Shippable> toShip = shippingMapper.map(items);

        for (CartItem item : items) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        if (!toShip.isEmpty()) {
            shippingService.startShipping(toShip);
        }
        Float subtotal = priceCalculator.calculateSubtotal(items);
        Float shipping = priceCalculator.calculateShipping(toShip);
        Float total = subtotal + shipping;
        customer.pay(total);
        receiptPrinter.print(items, subtotal, shipping, total, customer.getBalance());

    }


}
