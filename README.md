# 🛒 Fawry Rise Journey — E-Commerce System Challenge

This repository contains an **E-Commerce System** implemented in Java as part of the **Fawry Rise Journey Internship Challenge**. The system models a variety of shopping features, with clean code architecture and separation of concerns across services and models.

---

## 📌 Key Classes Overview

| Class/File                     | Role / Responsibility                                  |
|--------------------------------|--------------------------------------------------------|
| `Product`, `ShippableProducts` | Represents items in the store                          |
| `Cart`, `CartItem`             | Shopping cart and its contents                         |
| `Customer`                     | Represents the buyer                                   |
| `CartService`                  | Handles cart logic (add, remove, list items)           |
| `CheckOutService`              | Responsible for finalizing the purchase                |
| `ShippingService`              | Applies shipping rules and generates logistics info    |
| `PriceCalculator`              | Computes total cost and discounts                      |
| `ReceiptPrinter`               | Prints a receipt based on cart contents and total      |
| `CartValidator`                | Validates cart state before checkout                   |
| `ShippingMapper`               | Maps products to shipping data                         |
| `EcommerceStore`               | Simulates and connects components in a real-world flow |
| `Main.java`                    | Entry point(console app)                               |

---

## 🧪 Some Test Cases Screenshots

Here are some screenshots of test outputs and usage:

###### Project Running
<sup><sub>*Shipping fees: 30 EGP/Kg</sub></sup>
<div>
  <img src="./screenshots/project running console.png" width="300" height="200"/>
</div>




###### Cart and Product Logic Test
| Title                         | Screenshot                                                              |
|-------------------------------|-------------------------------------------------------------------------|
| Expired Product               | <img src="./screenshots/expired console.png" width="500"/>              |
| OutOfStock Product            | <img src="./screenshots/outofstock console.png" width="500"/>           |
| Insufficient Customer Balance | <img src="./screenshots/insufficient-balance console.png" width="500"/> |
| Empty Cart                    | <img src="./screenshots/cart-empty console.png" width="500"/>           |




---

## ⚙️ Requirements

| Tool        | Version                                      |
|-------------|----------------------------------------------|
| **Java**    | 21+                                          |
| **Build Tool** | Maven                                        |
| **IDE**     | IntelliJ IDEA recommended                    |
---

## 🚀 Run Instructions

1. Clone the repo:
   ```bash
   git clone https://github.com/Hazem-Amer/E-Commerce-Task
   


