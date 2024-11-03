package FileOperations.Nov03;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class EmployeeWorkLog {
    private static final String FILE_NAME = "work_log.csv";

    private static void run() {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("Enter the number of employees to log: ");
        num = sc.nextInt();
        sc.nextLine();

        int id;
        int days;
        String name;


        for (int i = 0; i < num; i++) {
            List<Float> hours = new ArrayList<>();
            System.out.println("\nEnter data for employee " + (i + 1) + ":");
            System.out.print("Enter Employee ID: ");
            id = sc.nextInt();

            System.out.print("Enter Name: ");
            name = sc.nextLine();
            sc.nextLine();

            System.out.print("Enter Number of Work Days: ");
            days = sc.nextInt();

            for (int j = 0; j < days; j++) {
                System.out.print("Enter Hours Worked for day " + (j + 1) + ": ");
                hours.add(sc.nextFloat());
            }

            double sum = hours.stream().mapToDouble(Float::doubleValue).sum();
            double average = hours.stream().mapToDouble(Float::doubleValue).average().orElse(0.0);

            addLog(id, name, sum, average);
        }

        System.out.println("\nCSV file created successfully!");
    }

    private static void addLog(int id, String name, double sum, double average) {
        File file = new File(FILE_NAME);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            if (file.length() == 0) {
                bw.write("Employee ID,Employee Name,Total Hours Worked,Average Daily Hours");
                bw.newLine();
            }

            // Ensure sum always has one decimal place (e.g., "15.0")
            String sumFormatted = String.format("%.1f", sum);

            // Format average to show one decimal place if possible, two if necessary
            String averageFormatted = (average * 10 % 1 == 0) ? String.format("%.1f", average) : String.format("%.2f", average);

            bw.write(id + "," + name + "," + sumFormatted + "," + averageFormatted);
            bw.newLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        run();
    }
}
