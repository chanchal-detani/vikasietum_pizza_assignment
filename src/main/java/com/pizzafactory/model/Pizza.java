package com.pizzafactory.model;

import java.util.List;

public abstract class Pizza {
    protected String name;
    protected Size size;
    protected Crust crust;
    protected List<Topping> toppings;
    protected boolean extraCheese;

    public Pizza(String name, Size size, Crust crust, List<Topping> toppings, boolean extraCheese) {
        this.name = name;
        this.size = size;
        this.crust = crust;
        this.toppings = toppings;
        this.extraCheese = extraCheese;
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    public Crust getCrust() {
        return crust;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public boolean hasExtraCheese() {
        return extraCheese;
    }

    public abstract boolean isVegetarian();

    public abstract int basePrice();
}
