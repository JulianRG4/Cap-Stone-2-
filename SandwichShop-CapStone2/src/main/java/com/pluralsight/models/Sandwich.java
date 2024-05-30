package com.pluralsight.models;

import java.util.List;

public class Sandwich
{
    private String name;
    private String breadType;
    private boolean toasted;
    private String size;
    private List<String> toppings;
    private double price;

    public Sandwich(String name, String breadType, boolean toasted, String size, List<String> toppings) {
        this.name = name;
        this.breadType = breadType;
        this.toasted = toasted;
        this.size = size;
        this.toppings = toppings;
        this.price = calculateBasePrice(size);
    }

    private double calculateBasePrice(String size) {
        switch (size) {
            case "4\"":
                return 5.50;
            case "8\"":
                return 7.00;
            case "12\"":
                return 8.50;
            default:
                return 5.00;
        }
    }

    public void addPrice(double extraPrice) {
        this.price += extraPrice;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Sandwich[" +
                "Name: " + name  +
                ", breadType: " + breadType  +
                ", Is Toasted: " + toasted +
                ", size: " + size + '"' +
                ", price: " + price +
                ']';
    }
}