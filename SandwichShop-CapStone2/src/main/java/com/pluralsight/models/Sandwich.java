package com.pluralsight.models;

import java.util.List;
import java.util.stream.Collectors;

public class Sandwich {
    private String name;
    private String breadType;
    private boolean toasted;
    private String size;
    private List<String> premiumMeats;
    private List<String> premiumCheeses;
    private List<String> regularToppings;
    private List<String> sauces;
    private List<String> sides;
    private double price;

    public Sandwich(String name, String breadType, boolean toasted, String size, List<String> premiumMeats, List<String> premiumCheeses, List<String> regularToppings, List<String> sauces, List<String> sides) {
        this.name = name;
        this.breadType = breadType;
        this.toasted = toasted;
        this.size = size;
        this.premiumMeats = premiumMeats;
        this.premiumCheeses = premiumCheeses;
        this.regularToppings = regularToppings;
        this.sauces = sauces;
        this.sides = sides;
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
                "Name: " + name +
                ", Bread Type: " + breadType +
                ", Is Toasted: " + toasted +
                ", Size: " + size + '"' +
                ", Premium Meats: " + mapSelectionsToNames(premiumMeats, PremiumToppings.getPremiumMeats()) +
                ", Premium Cheeses: " + mapSelectionsToNames(premiumCheeses, PremiumToppings.getPremiumCheeses()) +
                ", Regular Toppings: " + mapSelectionsToNames(regularToppings, RegularToppings.getRegularToppings()) +
                ", Sauces: " + mapSelectionsToNames(sauces, RegularToppings.getSauces()) +
                ", Sides: " + mapSelectionsToNames(sides, RegularToppings.getSides()) +
                ", Price: $" + String.format("%.2f", price) +
                ']';
    }

    private List<String> mapSelectionsToNames(List<String> selections, List<String> availableOptions) {
        return selections.stream()
                .map(selection -> {
                    try {
                        int index = Integer.parseInt(selection) - 1;
                        return availableOptions.get(index);
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        return "Invalid selection";
                    }
                })
                .collect(Collectors.toList());
    }
}