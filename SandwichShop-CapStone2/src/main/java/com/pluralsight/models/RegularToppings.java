package com.pluralsight.models;

import java.util.Arrays;
import java.util.List;

public class RegularToppings extends Toppings {
    private static final List<String> regularToppings = Arrays.asList(
            "lettuce", "peppers", "onions", "tomatoes", "jalapenos",
            "cucumbers", "pickles", "guacamole", "mushrooms"
    );
    private static final List<String> sauces = Arrays.asList(
            "mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"
    );
    private static final List<String> sides = Arrays.asList(
            "au jus", "sauce"
    );

    public RegularToppings(String type) {
        super(type);
    }

    public static List<String> getRegularToppings() {
        return regularToppings;
    }

    public static List<String> getSauces() {
        return sauces;
    }

    public static List<String> getSides() {
        return sides;
    }

    @Override
    public double getPrice(String size, int count) {
        return 0.0;
    }
}