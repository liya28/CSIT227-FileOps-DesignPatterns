package DesignPatterns.AbstractFactory.GUIApplication.ConcreteFactories;

import DesignPatterns.AbstractFactory.GUIApplication.ConcreteProducts.*;
import DesignPatterns.AbstractFactory.GUIApplication.FactoryInterface.GUIFactory;
import DesignPatterns.AbstractFactory.GUIApplication.ProductInterfaces.*;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton(String name, String theme) {
        return new WindowsButton(name, theme);
    }

    @Override
    public Checkbox createCheckbox(String name, String theme) {
        return new WindowsCheckbox(name, theme);
    }

    @Override
    public TextField createTextField(String placeholder, String theme) {
        return new WindowsTextField(placeholder, theme);
    }

    @Override
    public Menu createMenu(String... items) {
        return new WindowsMenu(items);
    }

    @Override
    public Toolbar createToolbar(String... actions) {
        return new WindowsToolbar(actions);
    }
}
