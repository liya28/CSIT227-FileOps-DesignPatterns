package FileOperations.Problem1;
import java.io.*;
import java.util.*;

public class TextFileReadWrite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter input file name: ");
        String input_file = sc.nextLine();
        System.out.print("Enter output file name: ");
        String output_file = sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(input_file, true))) {
            System.out.print("Enter your content for " + input_file + ": ");
            String line;
            while (!(line = sc.nextLine()).equals("exit")) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Successfully written to " + input_file);
        } catch (IOException e) {
            System.out.println("Error occurred while writing to " + input_file);
        }

        System.out.print("Enter a word to replace: ");
        String old_word = sc.nextLine();
        System.out.print("Enter a new word: ");
        String new_word = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(input_file))) {
            System.out.println("Now reading...");
            String line;
            StringBuilder content = new StringBuilder();
            int word_count = 0;
            int line_count = 0;

            while ((line = br.readLine()) != null) {
                line_count++;
                String[] words = line.split("\\s");
                word_count += words.length;
                content.append(line.replace(old_word, new_word)).append("\n");
            }
            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter(output_file));
            bw.write(content.toString());
            bw.close();

            System.out.println("Word count: " + word_count);
            System.out.println("Line count: " + line_count);
            System.out.println("Successfully written to " + output_file);
        } catch (IOException ex) {
            ex.getMessage();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(output_file))) {
            System.out.println("Now reading...");
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
