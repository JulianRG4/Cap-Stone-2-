package com.pluralsight.userInterface;

import com.pluralsight.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeScreen {
    private Scanner scanner;
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public HomeScreen() {
        scanner = new Scanner(System.in);
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the Sandwich Shop!");
            System.out.println("[1]. Place an order");
            System.out.println("[2]. Exit");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    placeOrder();
                    break;
                case 2:
                    System.out.println("Thank you for visiting the Sandwich Shop!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void placeOrder() {
        boolean ordering = true;

        while (ordering) {
            System.out.println("1. Add a sandwich");
            System.out.println("2. Add a drink");
            System.out.println("3. Add chips");
            System.out.println("4. Complete order");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addSandwich();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    System.out.println("Completing order...");
                    System.out.println("Here's your order summary:");
                    displayOrderSummary();
                    System.out.println("Would you like to confirm the order? (yes/no): ");
                    String confirmChoice = scanner.nextLine();
                    if (confirmChoice.equalsIgnoreCase("yes")) {
                        saveOrder();
                        System.out.println("Order confirmed and saved.");
                    } else if (confirmChoice.equalsIgnoreCase("no")) {
                        System.out.println("Order canceled.");
                        resetOrder();
                    } else {
                        System.out.println("Invalid choice. Order canceled.");
                        resetOrder();
                    }
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private void displayOrderSummary() {
        System.out.println("\nOrder Summary:");
        for (Sandwich sandwich : sandwiches) {
            System.out.println("Sandwich: " + sandwich.getName() + ", Size: " + sandwich.getSize() + ", Price: $" + sandwich.calculateTotalPrice());
            System.out.println("Toppings: " + String.join(", ", sandwich.getSelectedToppings()));
            System.out.println("Sauces: " + String.join(", ", sandwich.getSelectedSauces()) + "\n");
        }

        for (Drink drink : drinks) {
            System.out.println("Drink: " + drink.getName() + ", Size: " + drink.getSize() + ", Price: $" + drink.getPrice() + "\n");
        }

        for (Chips chipsItem : chips) {
            System.out.println("Chips: " + chipsItem.getName() + ", Price: $" + chipsItem.getPrice() + "\n");
        }
    }

    private void addSandwich() {
        System.out.println("Creating a new sandwich...");

        System.out.print("Enter name on sandwich: ");
        String name = scanner.nextLine();

        System.out.print("Enter sandwich size (4\", 8\", 12\"): ");
        String size = scanner.nextLine();

        System.out.print("Enter bread type (white, wheat, rye, wrap): ");
        String bread = scanner.nextLine();

        // Determine the base price based on the size
        double basePrice;
        switch (size)
        {
            case "4":
                basePrice = 5.50;
                break;
            case "8":
                basePrice = 7.00;
                break;
            case "12":
                basePrice = 8.50;
                break;
            default:
                System.out.println("Invalid size.");
                return;
        }


        Sandwich sandwich = new Sandwich(name + "'s sandwich on " + bread + " bread", basePrice, size);

        // Selecting premium toppings
        System.out.println("Select one meat (Enter 'none' to skip):");
        List<String> meats = Topping.getMeats();
        for (int i = 0; i < meats.size(); i++)
        {
            System.out.println((i + 1) + ". " + meats.get(i));
        }
        String meatChoice = scanner.nextLine();
        if (!meatChoice.equalsIgnoreCase("none"))
        {
            int choiceIndex = Integer.parseInt(meatChoice);
            if (choiceIndex > 0 && choiceIndex <= meats.size())
            {
                String meat = meats.get(choiceIndex - 1);
                sandwich.addTopping(meat);
                sandwich.addPrice(Topping.getMeatPrice(size));
                System.out.println(meat + " added to your sandwich.");
            }
            else
            {
                System.out.println("Invalid choice. Premium topping not added.");
            }
        }

        // Selecting extra meat
        if (!meatChoice.equalsIgnoreCase("none"))
        {
            System.out.print("Would you like extra meat? (yes/no): ");
            String extraMeatChoice = scanner.nextLine();
            if (extraMeatChoice.equalsIgnoreCase("yes"))
            {
                sandwich.addPrice(Topping.getExtraMeatPrice(size));
                System.out.println("Extra meat added to your sandwich.");
            }
        }

        // Selecting cheese
        System.out.println("Select one cheese (Enter 'none' to skip):");
        List<String> cheeses = Topping.getCheeses();
        for (int i = 0; i < cheeses.size(); i++) {
            System.out.println((i + 1) + ". " + cheeses.get(i));
        }
        String cheeseChoice = scanner.nextLine();
        if (!cheeseChoice.equalsIgnoreCase("none"))
        {
            int choiceIndex = Integer.parseInt(cheeseChoice);
            if (choiceIndex > 0 && choiceIndex <= cheeses.size())
            {
                String cheese = cheeses.get(choiceIndex - 1);
                sandwich.addTopping(cheese);
                sandwich.addPrice(Topping.getCheesePrice(size));
                System.out.println(cheese + " added to your sandwich.");
            } else {
                System.out.println("Invalid choice. Cheese not added.");
            }
        }

        // Selecting extra cheese
        if (!cheeseChoice.equalsIgnoreCase("none"))
        {
            System.out.print("Would you like extra cheese? (yes/no): ");
            String extraCheeseChoice = scanner.nextLine();
            if (extraCheeseChoice.equalsIgnoreCase("yes"))
            {
                sandwich.addPrice(Topping.getExtraCheesePrice(size));
                System.out.println("Extra cheese added to your sandwich.");
            }
        }

        // Selecting regular toppings
        System.out.println("Select regular toppings (E.g 1,2,3) - Enter 'none' to skip:");
        List<String> regularToppings = Topping.getRegularToppings();
        for (int i = 0; i < regularToppings.size(); i++) {
            System.out.println((i + 1) + ". " + regularToppings.get(i));
        }
        String regularToppingChoice = scanner.nextLine();
        if (!regularToppingChoice.equalsIgnoreCase("none")) {
            String[] choices = regularToppingChoice.split(",");
            for (String choice : choices) {
                int toppingChoiceIndex = Integer.parseInt(choice.trim());
                if (toppingChoiceIndex > 0 && toppingChoiceIndex <= regularToppings.size()) {
                    String topping = regularToppings.get(toppingChoiceIndex - 1);
                    sandwich.addTopping(topping);
                    System.out.println(topping + " added to your sandwich.");
                } else {
                    System.out.println("Invalid choice. Regular topping not added.");
                }
            }
        }

        // Selecting sauces
        System.out.println("Select sauces (E.g 1,2,3) - Enter 'none' to skip:");
        List<String> sauces = Topping.getSauces();
        for (int i = 0; i < sauces.size(); i++) {
            System.out.println((i + 1) + ". " + sauces.get(i));
        }
        String sauceChoice = scanner.nextLine();
        if (!sauceChoice.equalsIgnoreCase("none")) {
            String[] choices = sauceChoice.split(",");
            for (String choice : choices) {
                int sauceChoiceIndex = Integer.parseInt(choice.trim());
                if (sauceChoiceIndex > 0 && sauceChoiceIndex <= sauces.size()) {
                    String sauce = sauces.get(sauceChoiceIndex - 1);
                    sandwich.addSauce(sauce);
                    System.out.println(sauce + " added to your sandwich.");
                } else {
                    System.out.println("Invalid choice. Sauce not added.");
                }
            }
        }

        // Selecting sides
        System.out.println("Select sides (E.g 1,2,3) - Enter 'none' to skip:");
        List<String> sides = new ArrayList<>();
        sides.add("au jus");
        sides.add("sauce");
        for (int i = 0; i < sides.size(); i++) {
            System.out.println((i + 1) + ". " + sides.get(i));
        }
        String sideChoice = scanner.nextLine();
        if (!sideChoice.equalsIgnoreCase("none")) {
            String[] choices = sideChoice.split(",");
            for (String choice : choices) {
                int sideChoiceIndex = Integer.parseInt(choice.trim());
                if (sideChoiceIndex > 0 && sideChoiceIndex <= sides.size()) {
                    String side = sides.get(sideChoiceIndex - 1);
                    sandwich.addSide(side);
                    System.out.println(side + " added to your sandwich.");
                } else {
                    System.out.println("Invalid choice. Side not added.");
                }
            }
        }

        System.out.print("Would you like to toast the sandwich? (yes/no): ");
        String toastChoice = scanner.nextLine();
        if (toastChoice.equalsIgnoreCase("yes")) {
            System.out.println("Your sandwich will be toasted.");
            sandwich.setToasted(true);
        }

        sandwiches.add(sandwich);
        System.out.println("Sandwich added to your order.");
    }

    private void addDrink() {
        System.out.println("Creating a new drink...");

        System.out.print("Enter the drink name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the drink size (Small, Medium, Large): ");
        String size = scanner.nextLine().toLowerCase();

        double price;
        switch (size) {
            case "small":
                price = 2.00;
                break;
            case "medium":
                price = 2.50;
                break;
            case "large":
                price = 3.00;
                break;
            default:
                System.out.println("Invalid size entered. Defaulting to small.");
                price = 2.00;
                size = "small"; // default size if input is invalid
        }

        Drink drink = new Drink(name, price, size);
        drinks.add(drink);
        System.out.println("Drink added to your order.");
    }

    private void addChips()
    {
        System.out.println("Creating a new chips...");

        System.out.print("Enter the chips name: ");
        String name = scanner.nextLine();

        double price = 1.50; // Fixed price for chips

        Chips chipsItem = new Chips(name, price);
        chips.add(chipsItem);
        System.out.println("Chips added to your order.");
    }

    private void saveOrder() {
        ReceiptWriter receiptWriter = new ReceiptWriter();
        receiptWriter.saveOrder(sandwiches, drinks, chips);
        receiptWriter.displayOrder(sandwiches, drinks, chips);
        resetOrder();
    }

    private void resetOrder() {
        sandwiches.clear();
        drinks.clear();
        chips.clear();
    }
}