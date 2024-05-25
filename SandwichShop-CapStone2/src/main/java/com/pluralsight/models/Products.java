package com.pluralsight.models;

public abstract class Products
{
    String name;
    double price;


    public Products(String name, String size, double price) {
        this.name = name;

        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getPrice()
    {
        return price;
    }
}

