
package com.pizzafactory;

import com.pizzafactory.model.*;
import com.pizzafactory.model.Order;
import com.pizzafactory.service.InventoryService;
import com.pizzafactory.service.OrderService;
import com.pizzafactory.store.InMemoryDatabase;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for PizzaFactory order processing.
 */
public class PizzaFactoryTest {

    private InventoryService inventoryService;
    private OrderService orderService;

    @BeforeEach
    public void setup() {
        InMemoryDatabase.getInventory().clear();
        inventoryService = new InventoryService();
        orderService = new OrderService();

        inventoryService.restock("Cheese Burst", 1);
        inventoryService.restock("New hand tossed", 10);
        inventoryService.restock("Black olive", 10);
        inventoryService.restock("Capsicum", 10);
        inventoryService.restock("Paneer", 10);
        inventoryService.restock("Mushroom", 10);
        inventoryService.restock("Chicken tikka", 10);
        inventoryService.restock("Barbeque chicken", 10);
        inventoryService.restock("Grilled chicken", 10);
        inventoryService.restock("Extra cheese", 10);
        inventoryService.restock("Cold drink", 10);
        inventoryService.restock("Mousse cake", 10);
    }

    @Test
    public void testValidVegPizzaOrder() {
        Pizza pizza = new VegPizza(
            "Deluxe Veggie",
            Size.MEDIUM,
            new Crust("Cheese Burst"),
            List.of(new Topping("Capsicum", true, 25), new Topping("Paneer", true, 35)),
            true
        );

        Side side = new Side("Cold drink", 55);
        Order order = new Order(List.of(pizza), List.of(side));

        boolean result = orderService.placeOrder(order);

        assertTrue(result);
        assertTrue(order.isConfirmed());
        assertEquals(200 + 25 + 35 + 35 + 55, order.getTotalAmount());
    }

    @Test
    public void testInvalidVegPizzaWithNonVegTopping() {
        Pizza pizza = new VegPizza(
            "Deluxe Veggie",
            Size.REGULAR,
            new Crust("Cheese Burst"),
            List.of(new Topping("Chicken tikka", false, 35)),
            false
        );

        Order order = new Order(List.of(pizza), List.of());

        boolean result = orderService.placeOrder(order);

        assertFalse(result);
        assertFalse(order.isConfirmed());
    }

    @Test
    public void testNonVegPizzaWithMultipleNonVegToppings() {
        Pizza pizza = new NonVegPizza(
            "Non-Veg Supreme",
            Size.REGULAR,
            new Crust("New hand tossed"),
            List.of(
                new Topping("Chicken tikka", false, 35),
                new Topping("Grilled chicken", false, 40)
            ),
            false
        );

        Order order = new Order(List.of(pizza), List.of());

        boolean result = orderService.placeOrder(order);

        assertFalse(result);
        assertFalse(order.isConfirmed());
    }

    @Test
    public void testLargePizzaWithTwoFreeToppings() {
        Pizza pizza = new VegPizza(
            "Paneer Tikka",
            Size.LARGE,
            new Crust("Cheese Burst"),
            List.of(
                new Topping("Black olive", true, 20),
                new Topping("Capsicum", true, 25)
            ),
            false
        );

        Order order = new Order(List.of(pizza), List.of());

        boolean result = orderService.placeOrder(order);

        assertTrue(result);
        assertTrue(order.isConfirmed());
        assertEquals(340, order.getTotalAmount());
    }

    @Test
    public void testLargePizzaWithMoreThanTwoToppings() {
        Pizza pizza = new VegPizza(
            "Paneer Tikka",
            Size.LARGE,
            new Crust("Cheese Burst"),
            List.of(
                new Topping("Black olive", true, 20),
                new Topping("Capsicum", true, 25),
                new Topping("Mushroom", true, 30)
            ),
            false
        );

        Order order = new Order(List.of(pizza), List.of());

        boolean result = orderService.placeOrder(order);

        assertTrue(result);
        assertTrue(order.isConfirmed());
        assertEquals(340 + 30, order.getTotalAmount());
    }

    @Test
    public void testOrderFailsWhenInventoryInsufficient() {
        // Order with just enough ingredients
        Pizza pizza = new VegPizza(
                "Deluxe Veggie",
                Size.REGULAR,
                new Crust("Cheese Burst"),
                List.of(new Topping("Capsicum", true, 25)),
                false
        );

        Side side = new Side("Cold drink", 55);

        // First order should succeed
        Order firstOrder = new Order(List.of(pizza), List.of(side));
        assertTrue(orderService.placeOrder(firstOrder), "First order should succeed");
        assertTrue(firstOrder.isConfirmed());

        // Second order should fail due to exhausted inventory
        Order secondOrder = new Order(List.of(pizza), List.of(side));
        boolean result = orderService.placeOrder(secondOrder);
        assertFalse(result, "Second order should fail due to inventory");
        assertFalse(secondOrder.isConfirmed());
    }
}
