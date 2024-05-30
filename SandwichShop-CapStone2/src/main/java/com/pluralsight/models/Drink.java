package com.pluralsight.models;

public class Drink extends Products implements Size {
    private String size;

    public Drink(String name, String size) {
        super(name, calculatePrice(size)); // Pass the calculated price based on size
        setSize(size);
    }

    private static double calculatePrice(String size) {
        switch (size.toLowerCase()) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                throw new IllegalArgumentException("Invalid size: " + size);
        }
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public String toString() {
        return "Drink: " + getName() + " (Size: " + getSize() + ", Price: $" + getPrice() + ")";
    }
}