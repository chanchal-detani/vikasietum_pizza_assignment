package com.pizzafactory.model;

import java.util.List;

public class Order {
    private final List<Pizza> pizzas;
    private final List<Side> sides;
    private int totalAmount;
    private boolean confirmed;

    public Order(List<Pizza> pizzas, List<Side> sides) {
        this.pizzas = pizzas;
        this.sides = sides;
        this.totalAmount = 0;
        this.confirmed = false;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public List<Side> getSides() {
        return sides;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void confirm() {
        this.confirmed = true;
    }
}
