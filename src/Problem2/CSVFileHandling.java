package Problem2;
import java.util.*;
import java.io.*;

public class CSVFileHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CSV file name: ");
        String fileName = sc.nextLine();

        createFile(fileName);
        readFile(fileName);

        System.out.println("Enter new student name: ");
        String name = sc.nextLine();
        System.out.println("Enter new student age: ");
        int age = sc.nextInt();
        System.out.println("Enter new student grade: ");
        int grade = sc.nextInt();
        appendStudent(fileName, name, age, grade);

    }

    private static void appendStudent(String fileName, String name, int age, int grade) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(name + "," + age + "," + grade);
            bw.newLine();
            System.out.println("New student added");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createFile(String fileName) {
        Scanner sc = new Scanner(System.in);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            System.out.println("Enter content in " + fileName + " (enter 'exit' to stop): ");
            String line;

            while (!((line = sc.nextLine()).equals("exit"))) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Successfully written to " + fileName);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Reading...");
            String line;
            int total_age = 0;
            int student_count = 0;

            System.out.println("Student Details: ");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("Name: " + data[0] + ", Age: " + data[1] + ", Grade: " + data[2]);
                total_age += Integer.parseInt(data[1]);

                student_count++;
            }

            if (student_count > 1) {
                System.out.println("Average Age: " + (total_age / (student_count)));
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
