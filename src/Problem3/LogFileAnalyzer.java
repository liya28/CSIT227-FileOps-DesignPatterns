package Problem3;
import java.util.*;
import java.io.*;

public class LogFileAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter log file name: ");
        String logFileName = sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(logFileName))) {
            String line;
            while (!(line = sc.nextLine()).equals("exit")) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> words = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(logFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] line_words = line.split("\\s+");
                for (String word : line_words) {
                    int index = words.indexOf(word);
                    if (index != -1) {
                        counts.set(index, counts.get(index) + 1);
                    } else {
                        words.add(word);
                        counts.add(1);
                    }
                }
            }

            System.out.println("Word Frequency: ");
            for (int i = 0; i < words.size(); i++) {
                System.out.println(words.get(i) + ": " + counts.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
