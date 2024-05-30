package com.pluralsight.userInterface;

import com.pluralsight.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeScreen {

    private static final Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;
        List<Order> orders = new ArrayList<>();

        while (running) {
            displayHomeOptions();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Order order = new Order();
                    orderScreen(order);
                    orders.add(order);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayHomeOptions()
    {
        System.out.println();
        System.out.println("Home Screen");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.print("Enter your choice: ");
    }

    private static void orderScreen(Order order) {
        boolean ordering = true;

        while (ordering) {
            displayOrderOptions();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addSandwich(order);
                    break;
                case 2:
                    addDrink(order);
                    break;
                case 3:
                    addChips(order);
                    break;
                case 4:
                    checkout(order);
                    break;
                case 0:
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayOrderOptions() {
        System.out.println("\nOrder Screen");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
        System.out.print("Enter your choice: ");
    }

    private static void addSandwich(Order order)
    {
        System.out.println("Adding Sandwich:");

        System.out.print("Name on sandwich: ");
        String name = scanner.nextLine();
        String breadType = chooseBreadType();
        String size = chooseSandwichSize();

        List<String> toppings = new ArrayList<>();
        double extraMeatPrice = chooseAndAddMeats(toppings, size);
        double extraCheesePrice = chooseAndAddCheeses(toppings, size);
        chooseAndAddRegularToppings(toppings);
        chooseAndAddSauces(toppings);
        chooseAndAddSides(toppings);

        boolean toasted = askForToastingPreference();

        Sandwich sandwich = new Sandwich(name, breadType, toasted, size, toppings);
        sandwich.addPrice(extraMeatPrice);
        sandwich.addPrice(extraCheesePrice);
        order.addSandwich(sandwich);

        System.out.println("Sandwich added to the order:");
        System.out.println(sandwich);
    }

    private static double chooseAndAddMeats(List<String> toppings, String size) {
        System.out.println("Available meat toppings:");
        printOptions(PremiumToppings.getPremiumMeats());
        System.out.println("Choose meat toppings (separated by ',') or type 'none':");
        String meatsInput = scanner.nextLine().trim().toLowerCase();
        double meatPrice = 0.0;

        if (!meatsInput.equals("none")) {
            String[] meats = meatsInput.split(",");
            for (int i = 0; i < meats.length; i++) {
                String meat = meats[i].trim();
                toppings.add(meat);

                if (i == 0) {
                    meatPrice += new PremiumToppings("meat").getBasePrice(size);
                } else {
                    meatPrice += new PremiumToppings("meat").getExtraPrice(size);
                }
            }
        }
        return meatPrice;
    }

    private static double chooseAndAddCheeses(List<String> toppings, String size) {
        System.out.println("Available cheese toppings:");
        printOptions(PremiumToppings.getPremiumCheeses());
        System.out.println("Choose cheese toppings (separated by ',') or type 'none':");
        String cheesesInput = scanner.nextLine().trim().toLowerCase();
        double cheesePrice = 0.0;

        if (!cheesesInput.equals("none")) {
            String[] cheeses = cheesesInput.split(",");
            for (int i = 0; i < cheeses.length; i++) {
                String cheese = cheeses[i].trim();
                toppings.add(cheese);

                if (i == 0) {
                    cheesePrice += new PremiumToppings("cheese").getBasePrice(size);
                } else {
                    cheesePrice += new PremiumToppings("cheese").getExtraPrice(size);
                }
            }
        }
        return cheesePrice;
    }

    private static void chooseAndAddRegularToppings(List<String> toppings) {
        System.out.println("Available regular toppings:");
        printOptions(RegularToppings.getRegularToppings());
        System.out.println("Choose regular toppings (separated by ',') or type 'none':");
        String regularToppingsInput = scanner.nextLine().trim().toLowerCase();
        if (!regularToppingsInput.equals("none")) {
            String[] regularToppings = regularToppingsInput.split(",");
            for (String topping : regularToppings) {
                toppings.add(topping.trim());
            }
        }
    }

    private static void chooseAndAddSauces(List<String> toppings) {
        System.out.println("Available sauces:");
        printOptions(RegularToppings.getSauces());
        System.out.println("Choose sauce toppings (separated by ',') or type 'none':");
        String saucesInput = scanner.nextLine().trim().toLowerCase();
        if (!saucesInput.equals("none")) {
            String[] sauces = saucesInput.split(",");
            for (String sauce : sauces) {
                toppings.add(sauce.trim());
            }
        }
    }

    private static void chooseAndAddSides(List<String> toppings)
    {
        System.out.println("Available sides:");
        printOptions(RegularToppings.getSides());
        System.out.println("Choose side toppings (separated by ',') or type 'none':");
        String sidesInput = scanner.nextLine().trim().toLowerCase();
        if (!sidesInput.equals("none"))
        {
            String[] sides = sidesInput.split(",");
            for (String side : sides)
            {
                toppings.add(side.trim());
            }
        }
    }

    private static void printOptions(List<String> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ") " + options.get(i));
        }
    }

    private static boolean askForToastingPreference() {
        System.out.print("Do you want your sandwich to be toasted? (yes/no): ");
        String choice = scanner.nextLine().toLowerCase();
        return choice.equals("yes");
    }

    private static String chooseBreadType() {
        System.out.println("Choose bread type:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                return "White";
            case 2:
                return "Wheat";
            case 3:
                return "Rye";
            case 4:
                return "Wrap";
            default:
                System.out.println("Invalid choice. Defaulting to White.");
                return "White";
        }
    }

    private static String chooseSandwichSize() {
        System.out.println("Choose sandwich size:");
        System.out.println("1) 4\"");
        System.out.println("2) 8\"");
        System.out.println("3) 12\"");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                return "4\"";
            case 2:
                return "8\"";
            case 3:
                return "12\"";
            default:
                System.out.println("Invalid choice. Defaulting to 4\".");
                return "4\"";
        }
    }

    private static void addDrink(Order order) {
        System.out.println("Adding Drink:");

        String size = chooseDrinkSize();

        String flavor = chooseDrinkFlavor();

        Drink drink = new Drink(flavor, size);
        order.addDrink(drink);

        System.out.println("Drink added to the order: " + drink);
    }

    private static String chooseDrinkSize() {
        System.out.println("Choose drink size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                return "Small";
            case 2:
                return "Medium";
            case 3:
                return "Large";
            default:
                System.out.println("Invalid choice. Defaulting to Small.");
                return "Small";
        }
    }

    private static String chooseDrinkFlavor() {
        System.out.println("Enter drink flavor: ");
        return scanner.nextLine();
    }

    private static void addChips(Order order) {
        System.out.println("Adding Chips:");

        String type = chooseChipType();

        Chips chips = new Chips(type);
        order.addChips(chips);

        System.out.println("Chips added to the order: " + chips);
    }

    private static String chooseChipType() {
        System.out.print("Enter chip type: ");
        return scanner.nextLine();
    }

    private static void checkout(Order order)
    {
        System.out.println("\nCheckout");
        System.out.println("Order details:");
        System.out.println(order);
        double totalPrice = order.calculateTotalPrice();
        System.out.println("Total price: $" + String.format("%.2f", totalPrice));

        System.out.println("\n1) Confirm");
        System.out.println("0) Cancel");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1)
        {
            ReceiptWriter.saveOrderReceipt(order);
            System.out.println("\n----------------------");
            System.out.println("Order confirmed. Thank you!");
            System.out.println("----------------------\n");

        } else
        {
            System.out.println("\n----------------------");
            System.out.println("Order cancelled.");
            System.out.println("----------------------\n");
        }
    }
}
