package org.example.model.cart;

import org.example.model.product.Product;

public class CartItem {
    private Product product;
    private Double quantity;

    public CartItem(Product product, Double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Float getSubPrice() {
        return product.getPrice() * quantity.floatValue();
    }

    public Double getQuantity() {
        return quantity;
    }
}
