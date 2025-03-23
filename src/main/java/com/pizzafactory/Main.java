package com.pizzafactory;

import com.pizzafactory.model.*;
import com.pizzafactory.service.InventoryService;
import com.pizzafactory.service.OrderService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryService();
        OrderService orderService = new OrderService();

        inventoryService.restock("Deluxe Veggie", 10);
        inventoryService.restock("Cheese Burst", 10);
        inventoryService.restock("Paneer", 10);
        inventoryService.restock("Capsicum", 10);
        inventoryService.restock("Cold drink", 10);
        inventoryService.restock("Extra cheese", 10);

        Pizza pizza = new VegPizza(
                "Deluxe Veggie",
                Size.MEDIUM,
                new Crust("Cheese Burst"),
                List.of(
                        new Topping("Paneer", true, 35),
                        new Topping("Capsicum", true, 25)
                ),
                true
        );

        Side drink = new Side("Cold drink", 55);

        Order order = new Order(List.of(pizza), List.of(drink));
        boolean success = orderService.placeOrder(order);

        if (success) {
            System.out.println("✅ Order placed successfully!");
            System.out.println("💰 Total amount: Rs. " + order.getTotalAmount());
        } else {
            System.out.println("❌ Order failed due to validation or inventory issue.");
        }
    }
}
