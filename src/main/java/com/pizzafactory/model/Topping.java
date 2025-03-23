package com.pizzafactory.model;

public class Topping {
    private final String name;
    private final boolean isVeg;
    private final int price;

    public Topping(String name, boolean isVeg, int price) {
        this.name = name;
        this.isVeg = isVeg;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public boolean isVeg() {
        return isVeg;
    }

    public int getPrice() {
        return price;
    }
}
