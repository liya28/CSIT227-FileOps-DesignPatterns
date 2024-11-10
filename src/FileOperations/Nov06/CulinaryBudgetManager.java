package FileOperations.Nov06;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CulinaryBudgetManager {
    private static final int BUFFER_SIZE = 1024;
    private static final String RECIPES_FILE = "recipes.csv";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String[]> recipes = new ArrayList<>();

        while (true) {
            System.out.println("Simple Recipe Cost Calculator");
            System.out.println("1. Add a new recipe");
            System.out.println("2. View recipes");
            System.out.println("3. Save and exit");
            System.out.print("Enter your choice (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addRecipe(recipes);
                    break;
                case 2:
                    viewRecipes(recipes);
                    break;
                case 3:
                    saveRecipesToCsv(recipes);
                    System.out.println("Recipes saved to " + RECIPES_FILE + ". Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addRecipe(ArrayList<String[]> recipes) {
        System.out.print("Enter recipe name: ");
        String name = scanner.nextLine();
        System.out.print("Enter recipe cost: ");
        double cost = scanner.nextDouble();

        recipes.add(new String[]{name, String.valueOf(cost)});
    }

    private static void saveRecipesToCsv(ArrayList<String[]> recipes) {
        File file = new File(RECIPES_FILE);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            if (file.length() == 0) {
                writer.write("Recipe Name,Cost\n");
            }
            for (String[] recipe : recipes) {
                writer.write(recipe[0] + "," + recipe[1] + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewRecipes(ArrayList<String[]> recipes) {
        System.out.println("\nCurrent Recipes:");
        System.out.println("Recipe Name         Cost");
        System.out.println("------------------------------");
        double value = 0;
        for (String[] recipe : recipes) {
            value = Double.parseDouble(recipe[1]);
            System.out.printf("%-19s $%.2f\n", recipe[0], value);
        }
    }
}
