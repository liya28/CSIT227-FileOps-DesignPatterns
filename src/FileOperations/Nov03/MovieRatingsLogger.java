package FileOperations.Nov03;

import java.util.*;
import java.io.*;

public class MovieRatingsLogger {
    private static final String FILE_NAME = "movie_ratings.csv";

    private static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many movies do you want to rate? ");
        int num = sc.nextInt();
        sc.nextLine();

        String title = "";
        int year = 0;
        double rate = 0;

        for (int i = 0; i < num; i++) {
            System.out.println("\nMovie " + (i + 1) + ": ");
            System.out.print("Enter movie title: ");
            title = sc.nextLine();

            System.out.print("Enter your rating (0-10): ");
            rate = sc.nextDouble();

            System.out.print("Enter release year: ");
            year = sc.nextInt();

            sc.nextLine();

            addRate(title, rate, year);
        }
        System.out.println("Movie ratings have been saved to " + FILE_NAME);
    }

    private static void addRate(String title, double rate, int year) {
        File file = new File(FILE_NAME);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            if (file.length() == 0) {
                bw.write("Title,Rating,Release Year");
                bw.newLine();
            }
            bw.write(title + "," + rate + "," + year);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }

    public static void main(String[] args) {
        run();
    }
}
