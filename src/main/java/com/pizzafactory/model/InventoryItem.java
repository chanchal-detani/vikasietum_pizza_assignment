package com.pizzafactory.model;

public class InventoryItem {
    private final String name;
    private int quantity;

    public InventoryItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void restock(int amount) {
        this.quantity += amount;
    }

    public boolean consume(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
            return true;
        }
        return false;
    }
}
