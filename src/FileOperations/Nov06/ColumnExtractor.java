package FileOperations.Nov06;

import java.io.*;
import java.util.*;

public class ColumnExtractor {
    private static final String FILENAME = "students.csv";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the subjects separated by \",\": ");
        String subjects = sc.nextLine();
        String[] subject_header = subjects.split(",");
        writeCSV(subject_header, sc);

        List<List<String>> student_data = readCSV();

        System.out.print("Enter the subject you want to calculate for: ");
        String subject = sc.nextLine();

        int total = totalMarks(student_data, subject);
        System.out.println("Total marks for subject " + subject + ": " + total);
    }

    private static void writeCSV(String[] subjects, Scanner sc) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            bw.write("Student,");
            bw.write(String.join(",", subjects));
            bw.newLine();

            System.out.print("Enter the number of students: ");
            int num = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < num; i++) {
                System.out.println("Enter details for student " + (i + 1) + ":");
                System.out.print("Enter name: ");
                String name = sc.nextLine();

                List<String> student_row = new ArrayList<>();
                student_row.add(name);

                for (String subject : subjects) {
                    System.out.print("Enter marks for subject " + subject + ": ");
                    String mark = sc.nextLine();
                    student_row.add(mark);
                }

                bw.write(String.join(",", student_row));
                bw.newLine();
            }

            System.out.println("CSV file created successfully for subjects " + String.join(",", subjects));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<List<String>> readCSV() {
        List<List<String>> student_data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                student_data.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return student_data;
    }

    public static int totalMarks(List<List<String>> student_data, String subject) {
        int total = 0;

        List<String> header = student_data.get(0);
        int subject_index = header.indexOf(subject);

        if (subject_index == -1) {
            System.out.println("Subject not found.");
            return total;
        }

        for (int i = 1; i < student_data.size(); i++) {
            try {
                total += Integer.parseInt(student_data.get(i).get(subject_index));
            } catch (NumberFormatException e) {
                System.out.println("Invalid format for student " + student_data.get(i).get(0));
            }
        }

        return total;
    }
}