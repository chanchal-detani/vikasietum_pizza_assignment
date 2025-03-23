package com.pizzafactory.businessrules;

import com.pizzafactory.model.Order;
import com.pizzafactory.service.BusinessRule;

import java.util.List;

public class BusinessRuleEngine {

    private final List<BusinessRule> rules = List.of(
        new VegPizzaRule(),
        new NonVegPizzaRule(),
        new CrustSelectionRule(),
        new NonVegToppingRule(),
        new LargePizzaToppingRule()
    );

    public boolean validate(Order order) {
        for (BusinessRule rule : rules) {
            if (!rule.validate(order)) {
                return false;
            }
        }
        return true;
    }
}
