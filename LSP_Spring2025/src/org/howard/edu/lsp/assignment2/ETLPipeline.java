package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

public class ETLPipeline {
    public static void main(String[] args) {
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        // Step 1: Extract Data
        List<String[]> rawData = extractData(inputPath);
        if (rawData.isEmpty()) {
            System.err.println("No data extracted. Exiting program.");
            return;
        }

        // Step 2: Transform Data
        List<String[]> transformedData = transformData(rawData);

        // Step 3: Load Data
        loadData(outputPath, transformedData);
    }

    private static List<String[]> extractData(String filePath) {
        List<String[]> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            boolean skipHeader = true;
            String line;

            while ((line = reader.readLine()) != null) {
                if (skipHeader) { 
                    skipHeader = false; // Ignore first row
                    continue;
                }
                records.add(line.split(",")); // Store each row as an array
            }
        } catch (IOException e) {
            System.err.println("Unable to access file: " + e.getMessage());
            return Collections.emptyList(); // Return empty list if error occurs
        }

        return records;
    }

    private static List<String[]> transformData(List<String[]> rawData) {
        List<String[]> modifiedData = new ArrayList<>();

        for (String[] row : rawData) {
            if (row.length < 4) continue; // Skip invalid rows

            String id = row[0];
            String name = row[1].toUpperCase(); // Standardize names
            
            double price;
            try {
                price = Double.parseDouble(row[2]); // Handle invalid numbers
            } catch (NumberFormatException e) {
                System.err.println("Invalid price for product ID " + id + ". Skipping row.");
                continue;
            }

            String category = row[3];

            // Apply discount if category is "Electronics"
            if (category.equals("Electronics")) {
                price *= 0.9; // Apply discount
                price = Math.round(price * 100.0) / 100.0; // Explicit rounding to 2 decimal places
                if (price > 500) category = "Premium Electronics"; // Adjust category
            }

            // Determine price range
            String priceRange = (price <= 10) ? "Low" :
                                (price <= 100) ? "Medium" :
                                (price <= 500) ? "High" : "Premium";

            modifiedData.add(new String[]{id, name, String.format("%.2f", price), category, priceRange});
        }

        return modifiedData;
    }

    private static void loadData(String outputPath, List<String[]> processedData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write("ProductID,Name,Price,Category,PriceRange\n"); // Header row
            
            for (String[] row : processedData) {
                writer.write(String.join(",", row) + "\n"); // Convert array to CSV format
            }
            
            System.out.println("Data successfully saved to " + outputPath);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
