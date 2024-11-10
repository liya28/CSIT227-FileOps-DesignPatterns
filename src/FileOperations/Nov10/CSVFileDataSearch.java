package FileOperations.Nov10;

import java.util.*;
import java.io.*;

public class CSVFileDataSearch {

    public static void main(String[] args) {
        // Generate sample files
        try {
            CSVWriter file1 = new CSVWriter("file1.csv", new String[]{"Name", "Age", "City"});
            file1.writeRow(new String[]{"John", "25", "New York"});
            file1.writeRow(new String[]{"Jane", "", "San Francisco"});
            file1.writeRow(new String[]{"Mike", "35", " "});
            file1.close();

            CSVWriter file2 = new CSVWriter("file2.csv", new String[]{"Name", "Age", "City"});
            file2.writeRow(new String[]{"Alice", "20", "Los Angeles"});
            file2.writeRow(new String[]{"Bob", "", "Los Angeles"});
            file2.writeRow(new String[]{"Charlie", "40", ""});
            file2.close();
        } catch (IOException e) {
            System.out.println("Error generating sample files: " + e.getMessage());
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String fileName = sc.nextLine();

        boolean exists = new File(fileName).exists();
        if (!exists) {
            System.out.println("Error: File not found.");
            return;
        }

        System.out.print("Enter the value to search for: ");
        String search = sc.nextLine().trim();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean found = false;
            List<String[]> match = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] deets = line.split(",");
                for (String detail : deets) {
                    if (detail.trim().equalsIgnoreCase(search)) {
                        found = true;
                        match.add(deets);
                        break;
                    }
                }
            }

            if (found) {
                System.out.println("Results found for value '" + search + "'" + ":");
                for (String[] row : match) {
                    System.out.print(String.join(",", row));
                }

            } else {
                System.out.println("No results found for value '" + search + "'");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


class CSVWriter {
    private final String fileName;
    private final String[] headers;
    private final List<String[]> rows;

    public CSVWriter(String fileName, String[] headers) throws IOException {
        this.fileName = fileName;
        this.headers = headers;
        this.rows = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void writeRow(String[] row) throws IOException {
        rows.add(row);
    }

    public void close() throws IOException {
        try (java.io.FileWriter fileWriter = new java.io.FileWriter(fileName)) {
            fileWriter.write(String.join(",", headers) + "\n");
            for (String[] row : rows) {
                fileWriter.write(String.join(",", row) + "\n");
            }
        }
    }
}