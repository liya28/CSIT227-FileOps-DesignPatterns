package FileOperations.Nov10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static FileOperations.Nov10.CSVColumnExtractor.writeCsvFile;

public class CSVFileDataFiltering {

    public static void main(String[] args) {
        String[][] file1 = { { "Name", "Age", "City" }, { "John", "25", "New York" }, { "Jane", "30", "San Francisco" },
                { "Mike", "35", "Chicago" } };

        String[][] file2 = { { "Name", "Age", "City" }, { "Alice", "20", "Los Angeles" }, { "Bob", "30", "Los Angeles" },
                { "Charlie", "40", "New York" } };

        String[][] file3 = { { "Name", "Age", "City" }, { "David", "25", "Chicago" }, { "Eva", "30", "Los Angeles" },
                { "Frank", "35", "New York" } };


        writeCsvFile("file1.csv", file1);
        writeCsvFile("file2.csv", file2);
        writeCsvFile("file3.csv", file3);

        Scanner sc = new Scanner(System.in);

        List<String[]> data = new ArrayList<>();

        System.out.print("Enter the file path: ");
        String file = sc.nextLine();

        System.out.print("Enter the column name to filter on: ");
        String column_name = sc.nextLine();

        System.out.print("Enter the condition to apply: ");
        String condition = sc.nextLine();

        System.out.println("Rows that satisfy the condition:");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            List<String> headers = List.of(line.split(","));
            int col_index = -1;
            if (headers.contains(column_name)) {
                col_index = headers.indexOf(column_name);
            }

            while ((line = br.readLine()) != null) {
                List<String> values = List.of(line.split(","));
                if (values.contains(condition)) {
                    System.out.println(String.join(",", values));
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}