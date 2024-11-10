package FileOperations.Nov06;
import java.util.*;
import java.io.*;

public class ProductInventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of products to add: ");
        int n = sc.nextInt();

        int id = 0, stock = 0;
        String name = "", category = "";
        float price = 0;
        File file = new File("inventory.csv");
        List<Integer> IDs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for product " + (i + 1) + ": ");

            while (true) {
                System.out.print("Enter Product ID: ");
                id = sc.nextInt();

                if (IDs.contains(id)) {
                    System.out.println("\nDuplicate Product ID");
                } else {
                    IDs.add(id);
                    break;
                }
            }

            sc.nextLine();

            System.out.print("Enter Product Name: ");
            name = sc.nextLine();

            System.out.print("Enter Category: ");
            category = sc.nextLine();

            while (true) {
                System.out.print("Enter Price: ");
                price = sc.nextFloat();
                if (price < 0) {
                    System.out.println("Price must be non-negative.");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.print("Enter Stock Quantity: ");
                stock = sc.nextInt();
                if (stock < 0) {
                    System.out.println("Stock Quantity must be non-negative.");
                } else {
                    break;
                }
            }

            createCSV(id, name, category, price, stock, file);
        }
        System.out.println("\nCSV file created successfully!");
    }

    private static void createCSV(int id, String name, String category, float price, int stock, File file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter (file, true))) {
            if (file.length() == 0) {
                bw.write("Product ID,Product Name,Category,Price,Stock Quantity\n");
            }

            bw.write(id + "," + name + "," + category + "," + price + "," + stock + "\n");
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
