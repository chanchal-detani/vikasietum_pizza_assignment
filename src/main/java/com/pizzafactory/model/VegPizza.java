
package com.pizzafactory.model;

import java.util.List;
import java.util.Map;

public class VegPizza extends Pizza {

    private static final Map<String, Map<Size, Integer>> PRICE_TABLE = Map.of(
        "Deluxe Veggie", Map.of(Size.REGULAR, 150, Size.MEDIUM, 200, Size.LARGE, 325),
        "Cheese and Corn", Map.of(Size.REGULAR, 175, Size.MEDIUM, 375, Size.LARGE, 475),
        "Paneer Tikka", Map.of(Size.REGULAR, 160, Size.MEDIUM, 290, Size.LARGE, 340)
    );

    public VegPizza(String name, Size size, Crust crust, List<Topping> toppings, boolean extraCheese) {
        super(name, size, crust, toppings, extraCheese);
    }

    @Override
    public boolean isVegetarian() {
        return true;
    }

    @Override
    public int basePrice() {
        return PRICE_TABLE.getOrDefault(name, Map.of()).getOrDefault(size, 0);
    }
}
