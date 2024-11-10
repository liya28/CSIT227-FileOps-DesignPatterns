package FileOperations.Nov10;

import java.io.*;
import java.util.*;

public class CSVFileDataAveraging {

    public static void main(String[] args) {
        // create sample CSV files for testing
        try {
            FileWriter file1 = new FileWriter("sample1.csv");
            file1.write("ID,Name,Age\n");
            file1.write("1,John,30\n");
            file1.write("2,Jane,25\n");
            file1.write("3,Bob,40\n");
            file1.close();

            FileWriter file2 = new FileWriter("sample2.csv");
            file2.write("Code,Description,Price\n");
            file2.write("A001,Product A,9.99\n");
            file2.write("B002,Product B,14.99\n");
            file2.write("C003,Product C,19.99\n");
            file2.close();

            FileWriter file3 = new FileWriter("sample3.csv");
            file3.write("Country,Capital,Population\n");
            file3.write("USA,Washington D.C.,328.2\n");
            file3.write("Japan,Tokyo,126.5\n");
            file3.write("France,Paris,66.99\n");
            file3.close();
        } catch (IOException e) {
            System.out.println("An error occurred while creating the sample CSV files.");
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the CSV file name/path: ");
        String fileName = sc.nextLine();

        boolean fileExists = new File(fileName).exists();

        if (!fileExists) {
            System.out.println("Error: " + fileName + " not found!");
            return;
        }

        System.out.print("Enter the column to average (by header name): ");
        String column = sc.nextLine();
        System.out.print("Enter the output format (integer or float): ");
        String format = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            String headerline = "";
            int col_index = -1;
            int count = 0;
            double sum = 0;

            headerline = br.readLine();

            String[] headers = headerline.split(",");
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].trim().equalsIgnoreCase(column)) {
                    col_index = i;
                    break;
                }
            }

            if (col_index == -1) System.out.println("hoy");

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length > col_index) {
                    try {
                        double value = Double.parseDouble(values[col_index].trim());
                        sum += value;
                        count++;
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            if (count > 0) {
                double average = sum / count;

                if (format.equalsIgnoreCase("integer")) {
                    System.out.println("Average " + column + ": " + (int)average);
                    return;
                }
                else if (format.equalsIgnoreCase("float")) {
                    System.out.printf("Average %s: %.2f", column, average);
                    return;
                }
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
