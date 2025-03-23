package com.pizzafactory.businessrules;

import com.pizzafactory.model.Order;
import com.pizzafactory.model.Pizza;
import com.pizzafactory.model.Topping;
import com.pizzafactory.service.BusinessRule;

public class NonVegToppingRule implements BusinessRule {
    @Override
    public boolean validate(Order order) {
        for (Pizza pizza : order.getPizzas()) {
            if (!pizza.isVegetarian()) {
                int count = 0;
                for (Topping topping : pizza.getToppings()) {
                    if (!topping.isVeg()) {
                        count++;
                    }
                }
                if (count > 1) return false;
            }
        }
        return true;
    }
}
