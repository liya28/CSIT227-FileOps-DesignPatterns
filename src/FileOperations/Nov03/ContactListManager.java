package FileOperations.Nov03;

import java.util.*;
import java.io.*;

public class ContactListManager {
    private static final String FILE_NAME = "contacts.csv";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nContact List Manager");
            System.out.println("1. Add a new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Search for a contact");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addContact(sc);
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContact(sc);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addContact(Scanner sc) {
        System.out.print("Enter the contact's name: ");
        String name = sc.nextLine();
        System.out.print("Enter the contact's phone number: ");
        String phone = sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(name + "," + phone);
            bw.newLine();
            System.out.println("Contact added successfully!");
        } catch (IOException e) {
            System.out.println("No contacts found.");
        }
    }

    private static void viewContacts() {
        List<String[]> contacts = loadContacts();

        if (contacts.isEmpty()) {
            return;
        } else {
            System.out.println("\nContacts:");
            System.out.println("Name\t\tPhone");
            System.out.println("-----------------");
            for (String[] contact : contacts) {
                System.out.printf("%s\t\t%s%n", contact[0], contact[1]);
            }
        }
    }

    private static void searchContact(Scanner sc) {
        System.out.print("Enter the name to search for: ");
        String search = sc.nextLine();

        List<String[]> contacts = loadContacts();
        boolean found = false;

        for (String[] contact : contacts) {
            if (contact[0].equalsIgnoreCase(search)) {
                System.out.println("\nContact found:");
                System.out.println("Name: " + contact[0]);
                System.out.println("Phone: " + contact[1]);
                found = true;
                break;
            }
        }
    }

    private static List<String[]> loadContacts() {
        List<String[]> contacts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] contact = line.split(",");
                if (contact.length == 2) {
                    contacts.add(contact);
                }
            }
        } catch (IOException e) {
            System.out.println("No contacts found.");
        }

        return contacts;
    }
}