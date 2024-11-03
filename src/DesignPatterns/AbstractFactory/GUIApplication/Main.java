package DesignPatterns.AbstractFactory.GUIApplication;
import DesignPatterns.AbstractFactory.GUIApplication.ConcreteFactories.MacFactory;
import DesignPatterns.AbstractFactory.GUIApplication.ConcreteFactories.WindowsFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Application app;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the GUI Platform (Windows/MacOS): ");
        String platform = sc.nextLine();

        if (platform.equals("Windows")) {
            app = new Application(new WindowsFactory(), platform);
        } else if (platform.equals("MacOS")) {
            app = new Application(new MacFactory(), platform);
        } else {
            System.out.println("Unknown platform. Exiting...");
            return;
        }

       app.createUI();
    }
}
