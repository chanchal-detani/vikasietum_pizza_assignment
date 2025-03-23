package com.pizzafactory.businessrules;

import com.pizzafactory.model.Pizza;
import com.pizzafactory.model.Size;
import com.pizzafactory.model.Topping;
import com.pizzafactory.service.BusinessRule;

import com.pizzafactory.model.Order;

public class LargePizzaToppingRule implements BusinessRule {
    @Override
    public boolean validate(Order order) {
        return true; // No blocking rule, pricing only
    }

    public int calculateToppingPrice(Pizza pizza) {
        if (pizza.getSize() == Size.LARGE) {
            return Math.max(0, pizza.getToppings().size() - 2) * 30;
        }
        return pizza.getToppings().stream().mapToInt(Topping::getPrice).sum();
    }
}
