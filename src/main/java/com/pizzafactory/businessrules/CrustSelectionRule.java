package com.pizzafactory.businessrules;

import com.pizzafactory.model.Order;
import com.pizzafactory.model.Pizza;
import com.pizzafactory.service.BusinessRule;

public class CrustSelectionRule implements BusinessRule {
    @Override
    public boolean validate(Order order) {
        for (Pizza pizza : order.getPizzas()) {
            if (pizza.getCrust() == null) {
                return false;
            }
        }
        return true;
    }
}
