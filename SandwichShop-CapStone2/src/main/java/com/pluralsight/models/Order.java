package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private Chips chips;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public Chips getChips() {
        return chips;
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chips) {
        this.chips = chips;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Sandwich sandwich : sandwiches) {
            totalPrice += sandwich.getPrice();
        }
        for (Drink drink : drinks) {
            totalPrice += drink.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Checkout\n");
        builder.append("Order Details:\n");
        builder.append("-Sandwiches-\n");
        if (sandwiches.isEmpty()) {
            builder.append("No sandwiches\n");
        } else {
            for (Sandwich sandwich : sandwiches) {
                builder.append(sandwich.toString()).append("\n");
            }
        }
        if (drinks.isEmpty()) {
            builder.append("No drinks\n");
        } else {
            for (Drink drink : drinks) {
                builder.append(drink.toString()).append("\n");
            }
        }

        builder.append(chips == null ? "No chips\n" : chips.toString() + "\n");
        double totalPrice = calculateTotalPrice();
        builder.append("Total price: $").append(String.format("%.2f", totalPrice)).append("\n");
        return builder.toString();
    }
}