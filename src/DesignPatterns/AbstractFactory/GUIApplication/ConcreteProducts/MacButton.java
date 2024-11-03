package DesignPatterns.AbstractFactory.GUIApplication.ConcreteProducts;
import DesignPatterns.AbstractFactory.GUIApplication.ProductInterfaces.Button;

public class MacButton implements Button {
    private String name;
    private String theme;
    private Runnable action;

    public MacButton(String name, String theme) {
        this.name = name;
    }

    @Override
    public void paint() {
        System.out.println("Applying " + theme + " theme to Mac button: " + name);
    }

    @Override
    public void setAction(Runnable action) {
        this.action = action;
    }

    @Override
    public String getName() {
        return name;
    }

    public void click() {
        if (action != null) {
            action.run();
        }
    }
}

