package com.pizzafactory.model;

public class Side {
    private final String name;
    private final int price;

    public Side(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
