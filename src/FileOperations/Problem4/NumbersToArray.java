package FileOperations.Problem4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NumbersToArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the file name: ");
        String fileName = sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            System.out.println("Enter numbers to add (type 'exit' once done): ");
            String line;
            while (!(line = sc.nextLine()).equals("exit")) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("File " + fileName + " has been created with the entered numbers.");
        } catch (IOException e) {
            e.getMessage();
        }

        ArrayList<Integer> numbers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
//            while ((line = br.readLine()) != null) {
//                try {
//                    int number = Integer.parseInt(line);
//                    numbers.add(number);
//                } catch (NumberFormatException e) {
//                    System.out.println("Skipping invalid number format: " + line);
//                }
//            }

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                for (String part : parts) {
                    try {
                        int number = Integer.parseInt(part.trim());
                        numbers.add(number);
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid number format: " + part);
                    }
                }
            }
            System.out.println("Numbers have been read from the file and stored in array.");
        } catch (IOException e) {
            e.getMessage();
        }

        int[] numbers_arr = numbers.stream().mapToInt(Integer::intValue).toArray();

        System.out.println("Array of numbers: ");
        for (int num : numbers_arr) {
            System.out.println(num + " ");
        }
    }
}
