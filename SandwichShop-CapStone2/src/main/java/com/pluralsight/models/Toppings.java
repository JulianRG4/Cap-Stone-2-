package com.pluralsight.models;

import java.util.ArrayList;

public abstract class Toppings
{
    private ArrayList<String> toppings;

    public Toppings() {
        toppings = new ArrayList<>();
    }

    protected void addTopping(String topping) {
        toppings.add(topping);
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }


}