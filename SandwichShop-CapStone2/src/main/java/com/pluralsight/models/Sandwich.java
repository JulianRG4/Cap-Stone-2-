package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Products implements Size {
    private String size;
    private boolean toasted;
    private List<String> selectedToppings;
    private List<String> selectedSauces;

    public Sandwich(String name, double price, String size) {
        super(name, price);
        this.size = size;
        this.selectedToppings = new ArrayList<>();
        this.selectedSauces = new ArrayList<>();
        this.toasted = false;
    }

    public void addTopping(String topping) {
        selectedToppings.add(topping);
    }

    public void addSauce(String sauce) {
        selectedSauces.add(sauce);
    }

    public void addPrice(double price) {
        setPrice(getPrice() + price);
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public boolean isToasted() {
        return toasted;
    }

    public List<String> getSelectedToppings() {
        return selectedToppings;
    }

    public List<String> getSelectedSauces() {
        return selectedSauces;
    }

    public double calculateTotalPrice() {
        double totalPrice = getPrice();

        for (String topping : selectedToppings) {
            if (Topping.getMeats().contains(topping))
            {
                totalPrice += getMeatPrice(size);
                if (selectedToppings.stream().filter(t -> t.equals(topping)).count() > 1)
                {
                    totalPrice += getExtraMeatPrice(size);
                }
            }
            else if (Topping.getCheeses().contains(topping))
            {
                totalPrice += getCheesePrice(size);
                if (selectedToppings.stream().filter(t -> t.equals(topping)).count() > 1)
                {
                    totalPrice += getExtraCheesePrice(size);
                }
            }
        }

        addPrice(totalPrice);

        return totalPrice;
    }

    public double getMeatPrice(String size) {
        switch (size) {
            case "4":
                return 1.00;
            case "8":
                return 2.00;
            case "12":
                return 3.00;
            default:
                return 0;
        }
    }

    public double getExtraMeatPrice(String size) {
        switch (size) {
            case "4":
                return 0.50;
            case "8":
                return 1.00;
            case "12":
                return 1.50;
            default:
                return 0;
        }
    }

    public double getCheesePrice(String size) {
        switch (size) {
            case "4":
                return 0.75;
            case "8":
                return 1.50;
            case "12":
                return 2.25;
            default:
                return 0;
        }
    }

    public double getExtraCheesePrice(String size) {
        switch (size) {
            case "4":
                return 0.30;
            case "8":
                return 0.60;
            case "12":
                return 0.90;
            default:
                return 0;
        }
    }


    @Override
    public String getSize() {

        return size;
    }

    public void addSide(String side) {

    }
}