package com.pluralsight.models;

public abstract class Toppings
{
    private String type;

    public Toppings(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract double getPrice(String size, int count);
}