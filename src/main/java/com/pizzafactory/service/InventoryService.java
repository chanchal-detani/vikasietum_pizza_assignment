package com.pizzafactory.service;

import com.pizzafactory.model.InventoryItem;
import com.pizzafactory.store.InMemoryDatabase;

public class InventoryService {

    public boolean isAvailable(String item) {
        InventoryItem inventoryItem = InMemoryDatabase.getItem(item);
        return inventoryItem != null && inventoryItem.getQuantity() > 0;
    }

    public boolean consume(String item) {
        InventoryItem inventoryItem = InMemoryDatabase.getItem(item);
        return inventoryItem != null && inventoryItem.consume(1);
    }

    public void restock(String item, int amount) {
        InventoryItem inventoryItem = InMemoryDatabase.getItem(item);
        if (inventoryItem != null) {
            inventoryItem.restock(amount);
        } else {
            InMemoryDatabase.addItem(new InventoryItem(item, amount));
        }
    }
}
