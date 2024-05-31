# Cap-Stone-2-
-This is a Sandwich Shop that allows the customer to order a sandwich, drink, and chips. For Sandwich, the customer selects through various options to select meat, cheese, toppings, sauces, and sides. The price of all these things are a added based on the size of the sandwich.
-This project was really difficult for me because trying to figure out the logic for extra meat and extra cheese was a constant problem in all versions of my code. I eventually added this -
 public double getBasePrice(String size) {
        switch (getType()) {
            case "meat":
                switch (size) {
                    case "4\"":
                        return 1.00;
                    case "8\"":
                        return 2.00;
                    case "12\"":
                        return 3.00;
                }
            case "cheese":
                switch (size) {
                    case "4\"":
                        return 0.75;
                    case "8\"":
                        return 1.50;
                    case "12\"":
                        return 2.25;
                }
        }
        return 0.0;
    }

    public double getExtraPrice(String size) {
        switch (getType()) {
            case "meat":
                switch (size) {
                    case "4\"":
                        return 0.50;
                    case "8\"":
                        return 1.00;
                    case "12\"":
                        return 1.50;
                }
            case "cheese":
                switch (size) {
                    case "4\"":
                        return 0.30;
                    case "8\"":
                        return 0.60;
                    case "12\"":
                        return 0.90;
                }
        }
        return 0.0;
    }
    - By adding a second switch to handle extra meat and cheese I was able to add the price to the sandwich alot easier. At first I had both in the save switch and would return the price for both but I ran into problems with my logic.
    - Another Big struggle I had was my extra meat and cheese price would only add to the sandwich if two or more items were selected. With help I was able to identify the problem and solve it. The problem lied in my logic to only do the calculations if the items were greater then 1.
    -I would also like to move more of my code to their respective classes or to where I think they would be better suited but I ran out of time as I restarted this project multiple times. 
    Tuesday and Wednesday were the two days I restarted after realizing my base was first (Mainly in the wrong form) and second (Got way too complicated with amount of classes and scope). By having these two trials I was able to better prepare and learn. 
    - When I restarted I removed a lot of extra classes that I recognize will be used in the future but as far as implimentation, time did not permit me this weeek. 
    - Another big change was to how the customer was able to select their items. 
    -
     private static double calculatePrice(String size) {
        switch (size.toLowerCase()) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                throw new IllegalArgumentException("Invalid size: " + size);
        }
    }
-
With this code, the customer selects a number and that number is a case that returns the string size. Then I check for the size of the item and assign it a price based on its size. This works for the project but I realized I could have made the variables in the product (size) instead of (Price) because everything has a proce based on size but it was too late to change for this project. My products class ended up looking like this 
-
package com.pluralsight.models;

public abstract class Products
{
    private String name;
    private double price;

    public Products(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
-
I extended sandwich, drink, and chips from product but I also had a size interface that I had sandwich and drink implement from. I did not have chips implement size because it did not have one and had its base price always 1.50. 
-Overall I feel I learned a lot during this project and for the things I didn't learn, I feel I now know what I should study and work on more. I plan to do more practice projects in my spare time and really enjoyed the learning process of this Capstone