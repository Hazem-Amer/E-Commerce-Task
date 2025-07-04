package org.example.model.product;

import org.example.common.BaseEntity;

import java.time.LocalDate;


public class Product extends BaseEntity {
    private final String name;
    private Float price;
    private Float quantity;
    private LocalDate expiryDate;
    private Boolean isExpirable = false;

    public Product(String name, Float price, Float quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isExpirable = false;
    }

    public Product(String name, Float price, Float quantity, LocalDate expiryDate, Boolean isExpirable) {
        this(name, price, quantity);
        this.expiryDate = expiryDate;
        this.isExpirable = isExpirable;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public Float getQuantity() {
        return quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public Boolean getIsExpirable() {
        return isExpirable;
    }

    public void reduceQuantity(Float amount) {
        if (amount > quantity) throw new IllegalArgumentException("Not enough stock.");
        this.quantity -= amount;
    }

    public boolean isExpired() {
        return expiryDate != null && LocalDate.now().isAfter(expiryDate);
    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", expiryDate='" + expiryDate + '\'' +
                ", expirable=" + isExpirable +
                '}';
    }
}
