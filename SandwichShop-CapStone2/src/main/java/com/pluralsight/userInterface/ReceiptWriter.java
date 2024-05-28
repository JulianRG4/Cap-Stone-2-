package com.pluralsight.userInterface;

import com.pluralsight.models.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReceiptWriter {
    private String filename;

    public ReceiptWriter() {
        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        this.filename = "receipts/" + timestamp + ".txt";

        // Ensure the "receipts" directory exists
        File directory = new File("receipts");
        if (!directory.exists()) {
            directory.mkdirs();  // Creates the directory if it doesn't exist
        }
    }

    public void saveOrder(List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Order Details:\n\n");

            double totalPrice = 0.0; // Initialize total price

            for (Sandwich sandwich : sandwiches) {
                writer.write("Sandwich: " + sandwich.getName() + ", Size: " + sandwich.getSize() + ", Price: " + sandwich.calculateTotalPrice() + "\n");
                writer.write("Toppings: " + String.join(", ", sandwich.getSelectedToppings()) + "\n");
                writer.write("Sauces: " + String.join(", ", sandwich.getSelectedSauces()) + "\n\n");
                totalPrice += sandwich.calculateTotalPrice();
            }

            for (Drink drink : drinks) {
                writer.write("Drink: " + drink.getName() + ", Size: " + drink.getSize() + ", Price: " + drink.getPrice() + "\n\n");
                totalPrice += drink.getPrice();
            }

            for (Chips chipsItem : chips) {
                writer.write("Chips: " + chipsItem.getName() + ", Price: " + chipsItem.getPrice() + "\n\n");
                totalPrice += chipsItem.getPrice();
            }

            writer.write("Total Price: " + totalPrice + "\n");

            System.out.println("Order saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving order: " + e.getMessage());
        }
    }

    public void displayOrder(List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips) {
        System.out.println("\nOrder Details:\n");

        double totalPrice = 0.0;

        for (Sandwich sandwich : sandwiches) {
            System.out.println("Sandwich: " + sandwich.getName() + ", Size: " + sandwich.getSize() + ", Price: " + sandwich.calculateTotalPrice());
            System.out.println("Toppings: " + String.join(", ", sandwich.getSelectedToppings()));
            System.out.println("Sauces: " + String.join(", ", sandwich.getSelectedSauces()) + "\n");
            totalPrice += sandwich.calculateTotalPrice(); // Add sandwich price to total
        }

        for (Drink drink : drinks) {
            System.out.println("Drink: " + drink.getName() + ", Size: " + drink.getSize() + ", Price: " + drink.getPrice() + "\n");
            totalPrice += drink.getPrice();
        }

        for (Chips chipsItem : chips) {
            System.out.println("Chips: " + chipsItem.getName() + ", Price: " + chipsItem.getPrice() + "\n");
            totalPrice += chipsItem.getPrice();
        }

        System.out.println("Total Price: " + totalPrice + "\n");
    }
}