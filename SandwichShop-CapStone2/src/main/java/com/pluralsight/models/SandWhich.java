package com.pluralsight.models;

public class SandWhich extends Products implements Size
{
    private String breadType;
    private String toppings;



    public SandWhich(String name, String size, double price) {
        super(name, size, price);
    }

    @Override
    public String getSize() {
        return "";
    }
}
