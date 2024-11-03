package DesignPatterns.AbstractFactory.GUIApplication.ConcreteProducts;

import DesignPatterns.AbstractFactory.GUIApplication.ProductInterfaces.Button;

public class WindowsButton implements Button {
    private String name;
    private String theme;
    private Runnable action;

    public WindowsButton(String name, String theme) {
        this.name = name;
        this.theme = theme;
    }

    @Override
    public void paint() {
        System.out.println("Applying " + theme + " theme to button: " + name);
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
