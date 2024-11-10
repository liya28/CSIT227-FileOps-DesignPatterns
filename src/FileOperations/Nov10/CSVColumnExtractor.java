package FileOperations.Nov10;

import java.io.*;
import java.util.*;

public class CSVColumnExtractor {
    public static void main(String[] args) {

        List<List<String>> testData1 = new ArrayList<>();
        testData1.add(Arrays.asList("Name", "Age", "Gender"));
        testData1.add(Arrays.asList("John", "32", "Male"));
        testData1.add(Arrays.asList("Jane", "25", "Female"));
        testData1.add(Arrays.asList("Bob", "40", "Male"));

        List<List<String>> testData2 = new ArrayList<>();
        testData2.add(Arrays.asList("Name", "Age", "Gender"));
        testData2.add(Arrays.asList("Alice", "28", "Female"));
        testData2.add(Arrays.asList("Tom", "42", "Male"));
        testData2.add(Arrays.asList("Samantha", "33", "Female"));

        List<List<String>> testData3 = new ArrayList<>();
        testData3.add(Arrays.asList("Name", "Age", "Gender"));
        testData3.add(Arrays.asList("Michael", "45", "Male"));
        testData3.add(Arrays.asList("Emily", "29", "Female"));
        testData3.add(Arrays.asList("David", "37", "Male"));

//        writeCsvFile("test_data_1.csv", testData1);
//        writeCsvFile("test_data_2.csv", testData2);
//        writeCsvFile("test_data_3.csv", testData3);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String fileName = sc.nextLine();

        System.out.print("Enter column number: ");

        int col_index = sc.nextInt();
        col_index -= 1;

        List<String> column_data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                column_data.add(values[col_index]);
            }
            System.out.println(String.join(", ", column_data));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    static void writeCsvFile(String filename, String[][] data) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (String[] row : data) {
                writer.write(String.join(",", row));
                writer.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
