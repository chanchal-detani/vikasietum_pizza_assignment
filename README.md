s
# 🍕 PizzaFactory – Java-based Pizza Ordering Backend

Welcome to **PizzaFactory** – a lightweight, extensible, in-memory pizza ordering system designed using modern Java and SOLID principles.

> 🍕 "Good code is like good pizza – simple ingredients, perfect balance, infinite possibilities."

---

## 🧠 Problem Statement

A startup wants to build a backend service for handling pizza orders through self-service terminals. Customers can:

- Select one or more pizzas with crust, size, and toppings
- Add extra cheese
- Order sides like drinks or desserts
- Place the order (no payment flow required)

Vendors should be able to:
- Add pizzas/toppings/sides and update prices
- Restock ingredients/inventory

---

## ✅ Features

- 🧩 **Open/Closed Architecture** (add new rules without touching existing logic)
- 🧠 **Business Rules Engine** (pluggable rules: vegetarian validation, topping limits, crust check)
- 💾 **In-Memory Inventory Management** using collections
- ✅ **Extensive JUnit Tests** for every use case and edge case
- 🧼 **Clean Java** using latest Java features like `Map.of`, `List.of`, etc.
- 🧪 **Demo `Main.java`** to simulate real-world orders
- 📚 **Javadoc** on every class and method for clarity

---

## 🗂 Project Structure

```
PizzaFactory/
├── src/
    ├── main/
        ├── model/             -> Domain entities (Pizza, Toppings, Crust, Order, etc.)
        ├── service/           -> Inventory, Order, Pricing services
        ├── businessrules/     -> Rule engine and validation rules
        ├── store/             -> In-memory data store
        ├── test/              -> JUnit tests (PizzaFactoryTest)
        └── Main.java          -> Demo runner
    ├── test/             -> JUnit tests (PizzaFactoryTest)
```

---

## 📜 Business Rules Implemented

| Rule | Description |
|------|-------------|
| ✅ Vegetarian Pizza | Cannot have non-veg toppings |
| ✅ Non-Veg Pizza | Cannot include paneer topping |
| ✅ Crust Limit | Only one crust per pizza |
| ✅ Non-Veg Toppings | Only one non-veg topping allowed |
| ✅ Free Toppings | Large pizzas get 2 toppings free |

---

## 🚀 How to Run

### ▶️ Run Demo (`Main.java`)
1. Compile the project in your IDE or using `javac`
2. Run `Main.java` to simulate a real pizza order and print the result

### 🧪 Run Tests
Make sure JUnit 5 is set up, then run:
```
PizzaFactoryTest.java
```

---

## 🔧 Extending the System

- Add a new business rule? → Just implement `BusinessRule` and register it in `BusinessRuleEngine`.
- New pizza types or sizes? → Extend `Pizza` or update `PRICE_TABLE`s.
- Add REST API? → Easily wrap services in Spring Boot.

---

## 💡 Technologies Used

- Java 17+
- JUnit 5 (for testing)
- No frameworks – just clean OOP
- Pure in-memory collections (for simplicity)

---

## 👨‍💻 Author

Created by **Chanchal Detwani**  
As part of a backend architecture assignment focused on writing clean, extensible, and testable code.

---

## 📂 License

This project is for educational and demo purposes only. Feel free to extend it for your own pizza empire!
