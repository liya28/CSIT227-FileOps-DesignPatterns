package DesignPatterns.AbstractFactory.GUIApplication.ConcreteFactories;

import DesignPatterns.AbstractFactory.GUIApplication.ConcreteProducts.*;
import DesignPatterns.AbstractFactory.GUIApplication.FactoryInterface.GUIFactory;
import DesignPatterns.AbstractFactory.GUIApplication.ProductInterfaces.*;

public class MacFactory implements GUIFactory {
    @Override
    public Button createButton(String name, String theme) {
        return new MacButton(name, theme);
    }

    @Override
    public Checkbox createCheckbox(String name, String theme) {
        return new MacCheckbox(name, theme);
    }

    @Override
    public TextField createTextField(String placeholder, String theme) {
        return new MacTextField(placeholder, theme);
    }

    @Override
    public Menu createMenu(String... items) {
        return new MacMenu(items);
    }

    @Override
    public Toolbar createToolbar(String... actions) {
        return new MacToolbar(actions);
    }
}
