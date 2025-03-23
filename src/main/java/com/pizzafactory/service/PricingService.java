package com.pizzafactory.service;

import com.pizzafactory.businessrules.LargePizzaToppingRule;
import com.pizzafactory.model.Order;
import com.pizzafactory.model.Pizza;
import com.pizzafactory.model.Side;
import com.pizzafactory.model.Topping;

public class PricingService {

    private final LargePizzaToppingRule toppingRule = new LargePizzaToppingRule();

    public int calculateTotal(Order order) {
        int total = 0;

        for (Pizza pizza : order.getPizzas()) {
            total += pizza.basePrice();
            total += toppingRule.calculateToppingPrice(pizza);
            if (pizza.hasExtraCheese()) {
                total += 35;
            }
        }

        for (Side side : order.getSides()) {
            total += side.getPrice();
        }

        return total;
    }
}
