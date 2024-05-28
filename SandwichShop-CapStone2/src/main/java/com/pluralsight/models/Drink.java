package com.pluralsight.models;

public class Drink extends Products implements Size
{
    private String size;

    public Drink(String name, double price, String size)
    {
        super(name, price);
        this.size = size;
    }

    @Override
    public String getSize() {
        return this.size;
    }

    public void setSize(String size)
    {
        this.size = size;
    }
}