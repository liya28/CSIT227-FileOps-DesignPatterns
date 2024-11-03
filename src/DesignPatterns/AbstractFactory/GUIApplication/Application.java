package DesignPatterns.AbstractFactory.GUIApplication;

import DesignPatterns.AbstractFactory.GUIApplication.FactoryInterface.GUIFactory;
import DesignPatterns.AbstractFactory.GUIApplication.ProductInterfaces.*;

import java.util.Scanner;

public class Application {
    private GUIFactory factory;
    private ThemeManager themeManager;
    private String platform;

    public Application(GUIFactory factory, String platform) {
        this.factory = factory;
        this.platform = platform;
        this.themeManager = new ThemeManager();
    }

    public void createUI() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose theme (Light/Dark): ");
        String theme = sc.nextLine();
        themeManager.setTheme(theme);

        Button b = factory.createButton("Submit", theme);
        b.paint();
        b.setAction(() -> System.out.println("Submitted!"));

        Checkbox c = factory.createCheckbox("Accept Terms", theme);
        c.paint();
        CheckboxObserver o = new CheckboxObserver();
        c.setObserver(o);

        b.click();
        c.check();
        c.uncheck();

        TextField t = factory.createTextField("Enter your name", theme);
        t.paint();

        Menu m = factory.createMenu("File", "Edit");
        m.paint();

        Toolbar toolbar = factory.createToolbar("Save", "Open");
        toolbar.paint();

        System.out.println("\nFinal Output Compilation:");
        System.out.println("Platform: " + platform);
        System.out.println("Theme: " + theme);
        System.out.println("Button: " + b.getName());
        System.out.println("Button action: Submitted!");
        System.out.println("Checkbox: " + c.getName() + " (checked: " + c.isChecked() + ")");
        System.out.println("TextField: " + t.getText());
        System.out.println("Menu: " + "File, Edit");
        System.out.println("Toolbar: " + "Save, Open");
    }
}
