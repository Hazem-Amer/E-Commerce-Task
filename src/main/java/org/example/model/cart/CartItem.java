package org.example.model.cart;

import org.example.model.product.Product;

public class CartItem {
    private Product product;
    private Float quantity;

    public CartItem(Product product, Float quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getSubPrice() {
        return product.getPrice() * quantity.floatValue();
    }

    public Float getQuantity() {
        return quantity;
    }
}
