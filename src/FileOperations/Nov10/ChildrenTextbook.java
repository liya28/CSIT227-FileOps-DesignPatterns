package FileOperations.Nov10;

import java.io.*;
import java.util.*;

public class ChildrenTextbook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c;
        List<String> letters = new ArrayList<>();
        List<String> numbers = new ArrayList<>();

        do {
            System.out.print("Enter a character: ");
            c = sc.nextLine().charAt(0);

            if (Character.isDigit(c)) {
                numbers.add(String.valueOf(c));
            } else if (Character.isLetter(c)) {
                letters.add(String.valueOf(c));
            } else {
                break;
            }
        } while (true);

        Collections.sort(letters);
        System.out.println(Arrays.asList(letters.toArray()));
        Collections.sort(numbers);
        System.out.println(Arrays.asList(numbers.toArray()));

        letters.sort((s1, s2) -> {
            if (Character.isLowerCase(s1.charAt(0)) && Character.isLowerCase(s2.charAt(0))) {
                return s1.compareTo(s2);
            } else if (Character.isUpperCase(s1.charAt(0)) && Character.isUpperCase(s2.charAt(0))) {
                return s1.compareTo(s2);
            } else {
                if (Character.isLowerCase(s1.charAt(0))) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        System.out.println(Arrays.asList(letters.toArray()));

        new File("letters").mkdirs();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("letters/inputted.txt"))) {
            for (String letter : letters) {
                bw.write(letter);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        new File("numbers").mkdirs();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("numbers/inputted.txt"))) {
            for (String number : numbers) {
                bw.write(number);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
