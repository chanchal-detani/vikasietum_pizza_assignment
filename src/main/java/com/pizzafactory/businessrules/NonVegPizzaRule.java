package com.pizzafactory.businessrules;

import com.pizzafactory.model.Order;
import com.pizzafactory.model.Pizza;
import com.pizzafactory.model.Topping;
import com.pizzafactory.service.BusinessRule;

public class NonVegPizzaRule implements BusinessRule {
    @Override
    public boolean validate(Order order) {
        for (Pizza pizza : order.getPizzas()) {
            if (!pizza.isVegetarian()) {
                for (Topping topping : pizza.getToppings()) {
                    if (topping.getName().equalsIgnoreCase("Paneer")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
