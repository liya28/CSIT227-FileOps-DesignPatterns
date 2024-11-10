package FileOperations.Nov10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileWordCounter {
    public static void main(String[] args) {
        createSampleFiles();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String name = sc.nextLine();

        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(name))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        count++;
                    }
                }
            }
            System.out.println("Word count: " + count);
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    private static void createSampleFiles() {
        try {
            FileWriter file1 = new FileWriter("sample_file_1.txt");
            file1.write("This is sample file 1.\nIt has multiple lines.\nIt should have 3 lines in total.");
            file1.close();

            FileWriter file2 = new FileWriter("sample_file_2.txt");
            file2.write("This is sample file 2.\nIt has only 2 lines.");
            file2.close();

            FileWriter file3 = new FileWriter("sample_file_3.txt");
            file3.close();

            FileWriter file4 = new FileWriter("sample_file_4.txt");
            file4.write("   This  is  file 4.   \nIt has   a      lot     of white spaces  and new lines  \n");
            file4.close();
        } catch (IOException e) {
            System.out.println("Error creating sample files.");
        }
    }

}