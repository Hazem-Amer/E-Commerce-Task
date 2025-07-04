package org.example.utils;

import org.example.Service.shipment.Shippable;
import org.example.model.cart.CartItem;

import java.util.List;

public class ReceiptPrinter {
    public void print(List<CartItem> items, Float subtotal, Float shipping, Float total, Float balance) {
        System.out.println("** Checkout receipt **");
        for (CartItem item : items)
            System.out.printf("%fx %s\t%.0f%n", item.getQuantity(), item.getProduct().getName(), item.getSubPrice());
        System.out.println("----------------------");
        System.out.printf("Subtotal\t\t%.0f%n", subtotal);
        System.out.printf("Shipping\t\t%.0f%n", shipping);
        System.out.printf("Amount\t\t\t%.0f%n", total);
        System.out.printf("Customer balance\t%.0f%n", balance);
    }
    public void printShipmentNotice(List<Shippable> items) {
        float totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (Shippable item : items) {
            double weight = item.getWeight();
            System.out.printf("%-20s %.0fkg%n", item.getShippableName(), weight);
            totalWeight += weight;
        }
        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }
}
