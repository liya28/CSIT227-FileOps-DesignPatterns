package DesignPatterns.AbstractFactory.GUIApplication.ConcreteProducts;

import DesignPatterns.AbstractFactory.GUIApplication.ProductInterfaces.TextField;

public class MacTextField implements TextField {
    private String placeholder;
    private String text;

    public MacTextField(String placeholder, String theme) {
        this.placeholder = placeholder;
    }

    @Override
    public void paint() {
        System.out.println("Applying light theme to Mac text field: " + placeholder);
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
