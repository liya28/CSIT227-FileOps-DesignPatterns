package FileOperations.Nov09;

import java.util.*;
import java.io.*;

public class Average {
    private static final String FILENAME = "store_sales.csv";
    private static final String NEW_FILENAME = "sales_summary.csv";

    public static void main(String[] args) {
        List<String> headers = new ArrayList<String>() {{
            add("Date");
            add("Product");
            add("Quantity");
            add("Price Per Unit");
        }};

        writeCSV(headers);
        List<String[]> product_data = getProductData();
        List<String[]> summarized_data = getSummaryReport(product_data);
        writeNewCSV(summarized_data);
        List<String[]> highest_sales = getHighestSales(summarized_data);
        System.out.println("The product with the highest sales is " + Arrays.toString(highest_sales.get(0)) + " with total sales of " + Arrays.toString(highest_sales.get(2)));
    }

    private static void writeCSV(List<String> headers) {
        Scanner sc = new Scanner(System.in);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            bw.write(String.join(",", headers) + "\n");
            System.out.print("How many inputs will you add? ");
            int num = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < num; i++) {
                System.out.println("Enter details for product " + (i + 1) + ":");

                System.out.print("Enter date: ");
                String date = sc.nextLine();

                System.out.print("Enter product: ");
                String product = sc.nextLine();

                System.out.print("Enter quantity: ");
                String quantity = sc.nextLine();

                System.out.print("Enter price per unit: ");
                String price = sc.nextLine();

                bw.write(date + "," + product + "," + quantity + "," + price + "\n");
            }

            System.out.println(FILENAME + " created successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<String[]> getProductData() {
        List<String[]> product_data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                product_data.add(values);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return product_data;
    }

    private static List<String[]> getSummaryReport(List<String[]> product_data) {
        List<String[]> summarized_data = new ArrayList<>();

        for (String[] product : product_data) {
            String product_name = product[1];
            int quantity = Integer.parseInt(product[2]);
            double price = Double.parseDouble(product[3]);
            int total_sales = (int)(quantity * price);
            boolean found = false;

            for (String[] summary : summarized_data) {
                if (summary[0].equals(product_name)) {
                    int existing_quantity = Integer.parseInt(summary[1]);
                    int existing_sales = Integer.parseInt(summary[2]);

                    summary[1] = String.valueOf(existing_quantity + quantity);
                    summary[2] = String.valueOf(existing_sales + total_sales);

                    found = true;
                    break;
                }
            }

            if (!found) {
                summarized_data.add(new String[] {product_name, String.valueOf(quantity), String.valueOf(price), String.valueOf(total_sales)});
            }
        }

        return summarized_data;
    }

    private static void writeNewCSV(List<String[]> summarized_data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NEW_FILENAME))) {
            bw.write("Product,Total Quantity Sold,Total Sales\n");

            for (String[] row : summarized_data) {
                bw.write(String.join(",", row) + "\n");
            }

            System.out.println(NEW_FILENAME + " created successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<String[]> getHighestSales(List<String[]> summarized_data) {
        List<String[]> highest_sales = new ArrayList<>();
        int max_quantity = 0;

        for (String[] row : summarized_data) {
            if (max_quantity > Integer.parseInt(row[1])) {
                max_quantity = Integer.parseInt(row[1]);
                highest_sales = Collections.singletonList(row);
            }
        }

        return highest_sales;
    }
}