package org.example.Service.shipment;

import org.example.utils.ReceiptPrinter;

import java.util.List;

public class ShippingServiceImpl implements ShippingService {
    private final ReceiptPrinter receiptPrinter;
    public ShippingServiceImpl() {
        this.receiptPrinter  = new ReceiptPrinter();
    }
    @Override
    public void startShipping(List<Shippable> products) {
        receiptPrinter.printShipmentNotice(products);
    }
}
