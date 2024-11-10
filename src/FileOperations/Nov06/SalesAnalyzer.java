package FileOperations.Nov06;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SalesAnalyzer {
    private List<SalesData> sales;
    private String filename;

    public SalesAnalyzer(String filename) {
        sales = new ArrayList<>();
        this.filename = filename;
    }

    private static class SalesData {
        LocalDate date;
        String product;
        String salesperson;
        double amount;

        public SalesData(LocalDate date, String product, String salesperson, double amount) {
            this.date = date;
            this.product = product;
            this.salesperson = salesperson;
            this.amount = amount;
        }

        LocalDate getDate() {
            return date;
        }

        String getProduct() {
            return product;
        }

        String getSalesperson() {
            return salesperson;
        }

        double getAmount() {
            return amount;
        }
    }

    public void createSampleCSV() {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Date,Product,Salesperson,Amount\n");
            writer.write("2023-01-01,Laptop,John,1200\n");
            writer.write("2023-01-02,Desktop,Emma,1500\n");
            writer.write("2023-01-03,Laptop,Sarah,1100\n");
            writer.write("2023-01-04,Laptop,John,1300\n");
            writer.write("2023-01-05,Desktop,Emma,1400\n");
            writer.write("2023-01-06,Laptop,Sarah,900\n");
        } catch (IOException e) {
            System.err.println("Error creating sample CSV file: " + e.getMessage());
        }
    }

    public void loadData() {
        LocalDate date;
        String product, salesperson;
        double amount;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    date = LocalDate.parse(data[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    product = data[1];
                    salesperson = data[2];
                    amount = Double.parseDouble(data[3]);
                    sales.add(new SalesData(date, product, salesperson, amount));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void analyzeAndPrintResults() {
        String total = String.format("%.2f", calculateTotalSales());
        String product = findTopProduct();
        String salesperson = findTopPerformingSalesperson();
        String average = String.format("%.2f", calculateAverageSales());

        System.out.println("Total sales amount: $" + total);
        System.out.println("Top-selling product: " + product);
        System.out.println("Top-performing salesperson: " + salesperson);
        System.out.println("Average sale amount: $" + average);
        System.out.println("Number of sales by product:");

        ArrayList<Integer> num = numberOfSales();
        List<String> products = getUniqueProducts();

        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i) + ": " + num.get(i));
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("Total sales amount: $" + total + "\n");
            bw.write("Top-selling product: " + product + "\n");
            bw.write("Top-performing salesperson: " + salesperson + "\n");
            bw.write("Average sale amount: $ " + average + "\n");
            bw.write("Number of sales by product:" + "\n");
            for (int i = 0; i < products.size(); i++) {
                bw.write(products.get(i) + ": " + num.get(i) + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    double calculateTotalSales() {
        double total = 0;
        for (SalesData s : sales) {
            total += s.getAmount();
        }
        return total;
    }

    String findTopProduct() {
        double[] sales_amount = new double[sales.size()];
        List<String> products = new ArrayList<>();

        for (SalesData s : sales) {
            int index = products.indexOf(s.getProduct());

            if (index != -1) {
                sales_amount[index] += s.getAmount();
            } else {
                products.add(s.getProduct());
                sales_amount[products.size() - 1] = s.getAmount();
            }
        }

        double max_sales = 0;
        String top_product = "";

        for (int i = 0; i < sales_amount.length; i++) {
            if (sales_amount[i] > max_sales) {
                max_sales = sales_amount[i];
                top_product = products.get(i);
            }
        }

        return top_product;
    }

    String findTopPerformingSalesperson() {
        double[] sales_amount = new double[sales.size()];
        List<String> salespersons = new ArrayList<>();

        for (SalesData s : sales) {
            int index = salespersons.indexOf(s.getSalesperson());

            if (index != -1) {
                sales_amount[index] += s.getAmount();
            } else {
                salespersons.add(s.getSalesperson());
                sales_amount[salespersons.size() - 1] = s.getAmount();
            }
        }

        double max_sales = 0;
        String top_salesperson = "";

        for (int i = 0; i < sales_amount.length; i++) {
            if (sales_amount[i] > max_sales) {
                max_sales = sales_amount[i];
                top_salesperson = salespersons.get(i);
            }
        }

        return top_salesperson;
    }

    double calculateAverageSales() {
        int count = sales.size();
        double sales = calculateTotalSales();

        if (count == 0) {
            return 0.0;
        }

        return sales/count;
    }

    ArrayList<Integer> numberOfSales() {
        ArrayList<Integer> count = new ArrayList<>();
        List<String> products = new ArrayList<>();

        for (SalesData s : sales) {
            int index = products.indexOf(s.getProduct());

            if (index != -1) {
                count.set(index, count.get(index) + 1);
            } else {
                products.add(s.getProduct());
                count.add(1);
            }
        }
        return count;
    }

    List<String> getUniqueProducts() {
        List<String> products = new ArrayList<>();
        for (SalesData s : sales) {
            if (!products.contains(s.getProduct())) {
                products.add(s.getProduct());
            }
        }
        return products;
    }
}