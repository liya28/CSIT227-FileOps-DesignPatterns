package FileOperations.Nov09;

import java.util.*;
import java.io.*;

public class Sales {
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
    }

    private static void writeCSV(List<String> headers) {
        Scanner sc = new Scanner(System.in);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            bw.write(headers + "\n");
            System.out.print("How many products will you add? ");
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
}