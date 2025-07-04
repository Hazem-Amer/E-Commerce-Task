package org.example.model;

import org.example.common.BaseEntity;
import org.example.model.cart.Cart;

public class Customer extends BaseEntity {
    private String name;
    private Float balance;

    public Customer(String name, Float balance) {
        this.name = name;
        if(balance < 0) {
            throw new IllegalArgumentException("balance cannot be negative");
        }
        this.balance = balance;
    }

    public void pay(Float amount) {
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        balance -= amount;
    }


    public String getName() {
        return name;
    }

    public Float getBalance() {
        return balance;
    }


}
