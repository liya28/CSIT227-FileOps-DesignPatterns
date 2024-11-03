package DesignPatterns.AbstractFactory.GUIApplication.ConcreteProducts;
import DesignPatterns.AbstractFactory.GUIApplication.ProductInterfaces.Menu;

public class WindowsMenu implements Menu {
    private String[] items;

    public WindowsMenu(String...items) {
        this.items = items;
    }

    @Override
    public void paint() {
        System.out.println("Menu created: " + String.join(", ", items));
    }

    @Override
    public void selectItem(String item) {
        System.out.println(item + " menu selected.");
    }
}
