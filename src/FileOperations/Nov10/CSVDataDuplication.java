package FileOperations.Nov10;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVDataDuplication {
    public static void createSampleCSV(String filename, int sampleNumber) {
        File file = new File(filename);
        if (file.exists()) {
            return; // Skip if the file already exists
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println("name,description,price");
            if (sampleNumber == 1) {
                pw.println("Widget,A small widget,19.99");
                pw.println("Widget,A small widget,19.99");
                pw.println("Gadget,A handy gadget,29.99");
                pw.println("Device,An electronic device,39.99");
                pw.println("Gadget,A handy gadget,29.99");
            } else if (sampleNumber == 2) {
                pw.println("Book,An old book,9.99");
                pw.println("Book,An old book,9.99");
                pw.println("Pen,A blue pen,1.99");
                pw.println("Notebook,A spiral notebook,4.99");
                pw.println("Pen,A blue pen,1.99");
            } else if (sampleNumber == 3) {
                pw.println("Laptop,A gaming laptop,999.99");
                pw.println("Laptop,A gaming laptop,999.99");
                pw.println("Mouse,A wireless mouse,19.99");
                pw.println("Keyboard,A mechanical keyboard,49.99");
                pw.println("Mouse,A wireless mouse,19.99");
            } else {
                pw.println("Phone,A smartphone,699.99");
                pw.println("Phone,A smartphone,699.99");
                pw.println("Tablet,A new tablet,299.99");
                pw.println("Charger,A fast charger,25.99");
                pw.println("Charger,A fast charger,25.99");
            }
        } catch (IOException e) {
            System.out.println("Error creating sample CSV file.");
        }
    }

    public static class Product {
        String name;
        String description;
        float price;
    }

    public static void writeCSV(String filename, List<Product> products) {
        try {
            // Check if the file content is the same before writing
            StringBuilder currentContent = new StringBuilder("name,description,price\n");
            for (Product product : products) {
                currentContent.append(String.format("%s,%s,%.2f%n", product.name, product.description, product.price));
            }

            Path path = Paths.get(filename);
            if (Files.exists(path)) {
                String existingContent = Files.readString(path);
                if (existingContent.equals(currentContent.toString())) {
                    System.out.println("No changes detected in " + filename + ". Skipping write operation.");
                    return; // Exit if no changes are detected
                }
            }

            // Write to the file if changes are detected or the file doesn't exist
            try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
                pw.print(currentContent);
            }
        } catch (IOException e) {
            System.out.println("Error writing CSV file.");
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            createSampleCSV("sample" + i + ".csv", i);
        }

        String filename = "";
        boolean exists = false;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the filename/path of the CSV file: ");
            filename = sc.nextLine();

            File file = new File(filename);
            if (file.exists()) {
                exists = true;
            } else {
                System.out.println("Input file does not exist.");
            }
        } while (!exists);

        List<String[]> output_data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            output_data.add(line.split(","));

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                boolean is_dup = false;
                for (String[] product : output_data) {
                    if (product[0].equals(values[0]) && product[1].equals(values[1])) {
                        is_dup = true;
                        break;
                    }
                }

                if (!is_dup) {
                    output_data.add(values);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter("output.csv"))) {
            for (String[] product : output_data) {
                pw.println(String.join(",", product));
            }
            System.out.println("Duplicate products removed successfully!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
