package com.pluralsight.models;

public class RegularToppings extends Toppings
{

    public RegularToppings()
    {
        super();
        addDefaultToppings();
    }

    private void addDefaultToppings() {
        // Regular Toppings
        addTopping("lettuce");
        addTopping("peppers");
        addTopping("onions");
        addTopping("tomatoes");
        addTopping("jalapenos");
        addTopping("cucumbers");
        addTopping("pickles");
        addTopping("guacamole");
        addTopping("mushrooms");

        // Sauces
        addTopping("mayo");
        addTopping("mustard");
        addTopping("ketchup");
        addTopping("ranch");
        addTopping("thousand islands");
        addTopping("vinaigrette");

        // Sides
        addTopping("au jus");
        addTopping("sauce");
    }

}