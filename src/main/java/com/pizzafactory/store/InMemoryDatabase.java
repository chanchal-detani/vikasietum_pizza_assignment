package com.pizzafactory.store;

import com.pizzafactory.model.InventoryItem;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {
    private static final Map<String, InventoryItem> inventory = new HashMap<>();

    public static Map<String, InventoryItem> getInventory() {
        return inventory;
    }

    public static void addItem(InventoryItem item) {
        inventory.put(item.getName(), item);
    }

    public static InventoryItem getItem(String name) {
        return inventory.get(name);
    }
}
