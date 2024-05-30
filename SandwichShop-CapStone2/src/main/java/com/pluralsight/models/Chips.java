package com.pluralsight.models;

public class Chips extends Products
{
    public Chips(String name)
    {
        super(name, 1.50);
    }

    @Override
    public String toString() {
        return "Chips: " + getName() + " (Price: $" + getPrice() + ")";
    }
}