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
            writer.write(order.toString());
            double totalPrice = order.calculateTotalPrice();
            writer.write("Total price: $" + String.format("%.2f", totalPrice) + "\n");
            System.out.println("Receipt saved: " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to save receipt: " + e.getMessage());
        }
    }

    private static String generateReceiptFileName() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return now.format(formatter) + ".txt";
    }
}