package com.pizzafactory.service;

import com.pizzafactory.businessrules.BusinessRuleEngine;
import com.pizzafactory.model.Order;
import com.pizzafactory.model.Pizza;
import com.pizzafactory.model.Side;
import com.pizzafactory.model.Topping;

public class OrderService {

    private final InventoryService inventoryService = new InventoryService();
    private final PricingService pricingService = new PricingService();
    private final BusinessRuleEngine ruleEngine = new BusinessRuleEngine();

    public boolean placeOrder(Order order) {
        if (!ruleEngine.validate(order)) {
            return false;
        }

        for (Pizza pizza : order.getPizzas()) {
            if (!inventoryService.isAvailable(pizza.getCrust().getName())) return false;

            for (Topping topping : pizza.getToppings()) {
                if (!inventoryService.isAvailable(topping.getName())) return false;
            }

            if (pizza.hasExtraCheese()) {
                if (!inventoryService.isAvailable("Extra cheese")) return false;
            }
        }

        for (Side side : order.getSides()) {
            if (!inventoryService.isAvailable(side.getName())) return false;
        }

        for (Pizza pizza : order.getPizzas()) {
            inventoryService.consume(pizza.getCrust().getName());

            for (Topping topping : pizza.getToppings()) {
                inventoryService.consume(topping.getName());
            }

            if (pizza.hasExtraCheese()) {
                inventoryService.consume("Extra cheese");
            }
        }

        for (Side side : order.getSides()) {
            inventoryService.consume(side.getName());
        }

        int total = pricingService.calculateTotal(order);
        order.setTotalAmount(total);
        order.confirm();
        return true;
    }
}
