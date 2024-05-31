package com.pluralsight.userInterface;

import com.pluralsight.models.Order;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void saveOrderReceipt(Order order) {
        String fileName = generateReceiptFileName();
        String filePath = "receipts/" + fileName;

        File file = new File(filePath);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Checkout\n");
            writer.write("Order Details:\n");
            writer.write("Sandwiches:\n");
            writer.write(order.getSandwiches().isEmpty() ? "No sandwiches\n" : order.getSandwiches().toString() + "\n");
            writer.write("Drinks:\n");
            writer.write(order.getDrinks().isEmpty() ? "No drinks\n" : order.getDrinks().toString() + "\n");
            writer.write("Chips:\n");
            writer.write(order.getChips() == null ? "No chips\n" : order.getChips().toString() + "\n");
            double totalPrice = order.calculateTotalPrice();
            writer.write("Total price: $" + String.format("%.2f", totalPrice) + "\n");
            System.out.println("Receipt saved: " + fileName);
        } catch (IOException exception) {
            System.out.println("Sorry there was an error");
        }
    }

    private static String generateReceiptFileName() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return now.format(formatter) + ".txt";
    }
}