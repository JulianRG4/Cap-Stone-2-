package com.pluralsight.models;

public class PremiumToppings extends Toppings
{

    public PremiumToppings()
    {
        super();
        addDefaultToppings();
    }

    private void addDefaultToppings()
    {
        // Meats
        addTopping("steak");
        addTopping("ham");
        addTopping("salami");
        addTopping("roast beef");
        addTopping("chicken");
        addTopping("bacon");

        // Cheeses
        addTopping("american cheese");
        addTopping("provolone cheese");
        addTopping("cheddar cheese");
        addTopping("swiss cheese");
    }

}