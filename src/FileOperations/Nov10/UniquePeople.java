package FileOperations.Nov10;

import java.io.*;
import java.util.*;

public class UniquePeople {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        System.out.print("Enter the number of names: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            String name = sc.nextLine();

            boolean isDup = false;
            for (String existing_name : names) {
                if (existing_name.equalsIgnoreCase(name)) {
                    isDup = true;
                    break;
                }
            }

            if (!isDup) {
                names.add(name);
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("people.txt"))) {
            for (String name : names) {
                bw.write(name);
                bw.newLine();
            }
            System.out.println("Names have been saved to people.txt without duplicates.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
