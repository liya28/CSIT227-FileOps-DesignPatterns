package FileOperations.Nov03;
import java.io.*;
import java.util.*;

public class SalesDataPivot {
    private static final String INPUT_FILE = "sales_data.csv";
    private static final String OUTPUT_FILE = "pivoted_sales_data.csv";

    public static void main(String[] args) {
        createInputCSV();

        List<String[]> sales_data = readCSV(INPUT_FILE);
        List<String> products = new ArrayList<>();
        List<String> regions = new ArrayList<>();

        for (String[] row : sales_data) {
            String product = row[1];
            String region = row[2];

            if (!products.contains(product)) {
                products.add(product);
            }

            if (!regions.contains(region)) {
                regions.add(region);
            }
        }

        Collections.sort(products);
        Collections.sort(regions);

        List<List<String>> pivot_data = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Product");
        header.addAll(regions);
        pivot_data.add(header);

        for (String p : products) {
            List<String> row = new ArrayList<>(Collections.nCopies(regions.size() + 1, "0"));
            row.set(0, p);
            pivot_data.add(row);
        }

        for (String[] row : sales_data) {
            String product = row[1];
            String region = row[2];
            double sales = Double.parseDouble(row[3]);

            int product_index = products.indexOf(product) + 1;
            int region_index = regions.indexOf(region) + 1;

            double current_sales = Double.parseDouble(pivot_data.get(product_index).get(region_index));
            pivot_data.get(product_index).set(region_index, String.format("%.1f", current_sales + sales));
        }

        writeCSV(OUTPUT_FILE, pivot_data);
        System.out.println("Pivoted sales data has been written to '" + OUTPUT_FILE + "'.");
    }

    private static void createInputCSV() {
        String data = "Date,Product,Region,Sales\n" +
                "2023-01-01,Apple,North,10000\n" +
                "2023-01-02,Banana,South,20000\n" +
                "2023-01-03,Cherry,East,30000\n" +
                "2023-01-04,Apple,West,40000\n" +
                "2023-01-05,Banana,Central,50000";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(INPUT_FILE))) {
            bw.write(data);
            System.out.println("Input CSV file '" + INPUT_FILE + "' created.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<String[]> readCSV(String file_name) {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        return data;
    }

    private static void writeCSV(String file_name, List<List<String>> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file_name))) {
            for (List<String> row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
