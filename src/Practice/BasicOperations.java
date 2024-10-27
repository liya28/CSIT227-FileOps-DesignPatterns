package Practice;

import java.io.*;
import java.util.*;

public class BasicOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name to create or write to: ");
        String file_name = sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file_name, true))) {
            System.out.println("Enter content to write (type 'exit to stop): ");
            String input;
            while (!(input = sc.nextLine()).equals("exit")) {
                bw.write(input);
                bw.newLine();
            }
            System.out.println("Content successfully written to " + file_name);
        } catch (IOException e) {
            System.out.println("An error occured while writing to the file: " + file_name);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file_name))) {
            System.out.println("\nReading content from " + file_name + ":\n");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file " + file_name + " does not exist.");
        } catch (IOException e) {
            System.out.println("An error occured while reading from the file: " + e.getMessage());
        }

        sc.close();
    }
}