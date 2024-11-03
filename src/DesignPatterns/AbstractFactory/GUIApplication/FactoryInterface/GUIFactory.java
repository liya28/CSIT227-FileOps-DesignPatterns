package DesignPatterns.AbstractFactory.GUIApplication.FactoryInterface;

import DesignPatterns.AbstractFactory.GUIApplication.ProductInterfaces.*;

public interface GUIFactory {
    Button createButton(String name, String theme);
    Checkbox createCheckbox(String name, String theme);
    TextField createTextField(String placeholder, String theme);
    Menu createMenu(String... items);
    Toolbar createToolbar(String... actions);
}