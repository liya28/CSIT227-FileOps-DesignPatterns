package DesignPatterns.AbstractFactory.GUIApplication.ConcreteProducts;
import DesignPatterns.AbstractFactory.GUIApplication.ProductInterfaces.Toolbar;

public class MacToolbar implements Toolbar {
    private String[] actions;

    public MacToolbar(String... actions) {
        this.actions = actions;
    }

    @Override
    public void paint() {
        System.out.println("Toolbar created: " + String.join(", ", actions));
    }

    @Override
    public void performAction(String action) {
        System.out.println(action + " action performed.");
    }
}
