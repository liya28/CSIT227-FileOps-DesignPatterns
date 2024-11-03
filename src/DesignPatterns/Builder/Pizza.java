package DesignPatterns.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizza {
    private String size;
    private String crust;
    private String cheese;
    private List<String> toppings;
    private String spiciness;

    public Pizza(PizzaBuilder p) {
        this.size = p.size;
        this.crust = p.crust;
        this.cheese = p.cheese;
        this.toppings = p.toppings;
        this.spiciness = p.spiciness;
    }

    public static class PizzaBuilder {
        private String size;
        private String crust;
        private String cheese;
        private List<String> toppings;
        private String spiciness;

        public PizzaBuilder(String size, String crust) {
            this.size = size;
            this.crust = crust;
            this.cheese = "Regular";
            this.toppings = new ArrayList<>();
            this.spiciness = "Not Spicy";
        }

        public PizzaBuilder setCheese(String cheese) {
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder addTopping(String topping) {
            this.toppings.add(topping);
            return this;
        }

        public PizzaBuilder setSpiciness(String spiciness) {
            this.spiciness = spiciness;
            return this;
        }

        public Pizza cook() {
            return new Pizza(this);
        }
    }

    @Override
    public String toString() {
        return "\nPizza Order Summary:\n" +
                "Size: " + size + "\n" +
                "Crust: " + crust + "\n" +
                "Cheese: " + cheese + "\n" +
                "Toppings: " + toppings + "\n" +
                "Spiciness: " + spiciness;
    }
}

class PizzaMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO OUR PIZZERIA");

        System.out.print("Enter size (Small/Medium/Large): ");
        String size = sc.nextLine();

        System.out.print("Enter crust type (Thin/Thick/Stuffed): ");
        String crust = sc.nextLine();

        Pizza.PizzaBuilder chef = new Pizza.PizzaBuilder(size, crust);

        System.out.print("Do you want extra cheese? ");
        String cheese = sc.nextLine();
        if (cheese.equalsIgnoreCase("yes")) {
            chef.setCheese("Extra Cheese");
        } else {
            chef.setCheese("No Cheese");
        }

        System.out.print("Do you want to add toppings? (Yes/No): ");
        String toppings = sc.nextLine();

        while (toppings.equalsIgnoreCase("Yes")) {
            System.out.print("Enter topping (Pepperoni/Mushrooms/Onions/Olives/Green Peppers): ");
            String topping = sc.nextLine();

            chef.addTopping(topping);

            System.out.print("Do you want to add another topping? ");
            toppings = sc.nextLine();
        }

        System.out.print("Select spiciness level (Mild/Medium/Spicy): ");
        String spiciness = sc.nextLine();
        chef.setSpiciness(spiciness);

        Pizza pizza = chef.cook();

        System.out.println("\nYour pizza order:");
        System.out.println(pizza);
    }
}
