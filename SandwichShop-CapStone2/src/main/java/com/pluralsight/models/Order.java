package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        for (Sandwich sandwich : sandwiches) {
            total += sandwich.getPrice();
        }
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }
        for (Chips chip : chips) {
            total += chip.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder("Order Details:\n");
        orderDetails.append("Sandwiches:\n");
        for (Sandwich sandwich : sandwiches) {
            orderDetails.append(sandwich).append("\n");
        }
        orderDetails.append("Drinks:\n");
        for (Drink drink : drinks) {
            orderDetails.append(drink).append("\n");
        }
        orderDetails.append("Chips:\n");
        for (Chips chip : chips) {
            orderDetails.append(chip).append("\n");
        }
        return orderDetails.toString();
    }
}