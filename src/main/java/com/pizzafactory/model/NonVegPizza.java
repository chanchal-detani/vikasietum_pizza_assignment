
package com.pizzafactory.model;

import java.util.List;
import java.util.Map;

public class NonVegPizza extends Pizza {

    private static final Map<String, Map<Size, Integer>> PRICE_TABLE = Map.of(
        "Non-Veg Supreme", Map.of(Size.REGULAR, 190, Size.MEDIUM, 325, Size.LARGE, 425),
        "Chicken Tikka", Map.of(Size.REGULAR, 210, Size.MEDIUM, 370, Size.LARGE, 500),
        "Pepper Barbecue Chicken", Map.of(Size.REGULAR, 220, Size.MEDIUM, 380, Size.LARGE, 525)
    );

    public NonVegPizza(String name, Size size, Crust crust, List<Topping> toppings, boolean extraCheese) {
        super(name, size, crust, toppings, extraCheese);
    }

    @Override
    public boolean isVegetarian() {
        return false;
    }

    @Override
    public int basePrice() {
        return PRICE_TABLE.getOrDefault(name, Map.of()).getOrDefault(size, 0);
    }
}
