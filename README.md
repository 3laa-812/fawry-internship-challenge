# Fawry Internship Challenge – E-commerce System (Java)

This is a solution to the **Fawry Rise Journey – Full Stack Development Internship Challenge**.

## ✅ Challenge Requirements

Design an e-commerce system that includes:

- Products with `name`, `price`, and `quantity`
- Products that **may expire** (e.g., Cheese, Biscuits)
- Products that **may require shipping** (e.g., Cheese, TV) with `weight`
- A shopping cart that:
  - Adds products in quantities not exceeding available stock
  - Performs checkout that prints:
    - Subtotal
    - Shipping fees
    - Total amount
    - Customer’s current balance
  - Handles errors when:
    - Cart is empty
    - Product is expired or out of stock
    - Customer balance is insufficient
- A `ShippingService` that accepts shippable items and displays shipping details

---

## 🧱 Technologies Used

- **Java** (No frameworks)
- Core OOP principles (Abstraction, Inheritance, Encapsulation, Polymorphism)
- Java collections (`Map`, `List`)
- `LocalDate` for expiry dates

---

## 🧠 OOP Structure

- `abstract class Product` – base for all product types
- `interface Shippable` – for products that can be shipped
- `interface Expirable` – for products with expiry dates
- `class Cart` – adds products and stores them
- `class Customer` – contains balance and name
- `class CheckoutService` – handles all business logic and prints checkout summary

---

## ✅ Example Scenario

```java
cart.add(cheese, 2);
cart.add(biscuits, 1);
checkout(customer, cart);
```
## Console Output:
``` markdown
** Shipment notice **
2x Cheese      400g
1x Biscuits    700g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese      200
1x Biscuits    150
----------------------
Subtotal       350
Shipping       30
Amount         380
Customer Balance       620
```
---
📁 Project Structure
```css
│
├── Main.java
├── Product.java
├── Cheese.java
├── Biscuits.java
├── TV.java
├── MobileScratchCard.java
├── Expirable.java
├── Shippable.java
├── Customer.java
├── Cart.java
└── CheckoutService.java
```
---
## 🧑‍💻 Submitted By

- Alaa Ragab
`Front-End Developer`



