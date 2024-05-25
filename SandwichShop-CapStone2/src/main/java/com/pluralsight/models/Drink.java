package com.pluralsight.models;

public class Drink extends Products implements Size
{
    public Drink(String name, String size, double price)
    {
        super(name, size, price);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String getSize()
    {
        return "";
    }
}
