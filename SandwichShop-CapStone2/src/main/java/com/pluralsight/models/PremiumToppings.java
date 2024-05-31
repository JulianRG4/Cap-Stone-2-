package com.pluralsight.models;

import java.util.Arrays;
import java.util.List;

public class PremiumToppings extends Toppings {
    private static final List<String> premiumMeats = Arrays.asList(
            "steak", "ham", "salami", "roast beef", "chicken", "bacon"
    );
    private static final List<String> premiumCheeses = Arrays.asList(
            "american", "provolone", "cheddar", "swiss"
    );

    public PremiumToppings(String type) {
        super(type);
    }

    public static List<String> getPremiumMeats() {
        return premiumMeats;
    }

    public static List<String> getPremiumCheeses() {
        return premiumCheeses;
    }

    public double getBasePrice(String size) {
        switch (getType()) {
            case "meat":
                switch (size) {
                    case "4\"":
                        return 1.00;
                    case "8\"":
                        return 2.00;
                    case "12\"":
                        return 3.00;
                }
            case "cheese":
                switch (size) {
                    case "4\"":
                        return 0.75;
                    case "8\"":
                        return 1.50;
                    case "12\"":
                        return 2.25;
                }
        }
        return 0.0;
    }

    public double getExtraPrice(String size) {
        switch (getType()) {
            case "meat":
                switch (size) {
                    case "4\"":
                        return 0.50;
                    case "8\"":
                        return 1.00;
                    case "12\"":
                        return 1.50;
                }
            case "cheese":
                switch (size) {
                    case "4\"":
                        return 0.30;
                    case "8\"":
                        return 0.60;
                    case "12\"":
                        return 0.90;
                }
        }
        return 0.0;
    }

    @Override
    public double getPrice(String size, int count) {
        double price = 0.0;
        if (count > 0) {
            price += getBasePrice(size);
        }
        if (count > 1) {
            price += getExtraPrice(size) * (count - 1);
        }
        return price;
    }
}