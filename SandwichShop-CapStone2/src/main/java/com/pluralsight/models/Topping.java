package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Topping {
    private static final List<String> meats;
    private static final List<String> cheeses;
    private static final List<String> regularToppings;
    private static final List<String> sauces;
    private static final List<String> sides;

    static {
        meats = new ArrayList<>();
        meats.add("steak");
        meats.add("ham");
        meats.add("salami");
        meats.add("roast beef");
        meats.add("chicken");
        meats.add("bacon");

        cheeses = new ArrayList<>();
        cheeses.add("american");
        cheeses.add("provolone");
        cheeses.add("cheddar");
        cheeses.add("swiss");

        regularToppings = new ArrayList<>();
        regularToppings.add("lettuce");
        regularToppings.add("peppers");
        regularToppings.add("onions");
        regularToppings.add("tomatoes");
        regularToppings.add("jalapenos");
        regularToppings.add("cucumbers");
        regularToppings.add("pickles");
        regularToppings.add("guacamole");
        regularToppings.add("mushrooms");

        sauces = new ArrayList<>();
        sauces.add("mayo");
        sauces.add("mustard");
        sauces.add("ketchup");
        sauces.add("ranch");
        sauces.add("thousand islands");
        sauces.add("vinaigrette");

        sides = new ArrayList<>();
        sides.add("au jus");
        sides.add("sauce");
    }

    public static double getMeatPrice(String size) {
        switch (size) {
            case "4\"":
                return 1.00;
            case "8\"":
                return 2.00;
            case "12\"":
                return 3.00;
            default:
                return 0.00;
        }
    }

    public static double getExtraMeatPrice(String size) {
        switch (size) {
            case "4\"":
                return 0.50;
            case "8\"":
                return 1.00;
            case "12\"":
                return 1.50;
            default:
                return 0.00;
        }
    }

    public static double getCheesePrice(String size) {
        switch (size) {
            case "4\"":
                return 0.75;
            case "8\"":
                return 1.50;
            case "12\"":
                return 2.25;
            default:
                return 0.00;
        }
    }

    public static double getExtraCheesePrice(String size) {
        switch (size) {
            case "4\"":
                return 0.30;
            case "8\"":
                return 0.60;
            case "12\"":
                return 0.90;
            default:
                return 0.00;
        }
    }

    public static List<String> getMeats() {
        return new ArrayList<>(meats);
    }

    public static List<String> getCheeses() {
        return new ArrayList<>(cheeses);
    }

    public static List<String> getRegularToppings() {
        return new ArrayList<>(regularToppings);
    }

    public static List<String> getSauces() {
        return new ArrayList<>(sauces);
    }

    public static List<String> getSides() {
        return new ArrayList<>(sides);
    }
}