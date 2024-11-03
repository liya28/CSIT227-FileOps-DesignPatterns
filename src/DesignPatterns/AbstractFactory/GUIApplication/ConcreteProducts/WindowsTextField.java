package DesignPatterns.AbstractFactory.GUIApplication.ConcreteProducts;


import DesignPatterns.AbstractFactory.GUIApplication.ProductInterfaces.TextField;

public class WindowsTextField implements TextField {
    private String placeholder;
    private String theme;
    private String text;

    public WindowsTextField(String placeholder, String theme) {
        this.placeholder = placeholder;
        this.theme = theme;
    }

    @Override
    public void paint() {
        System.out.println("Applying " + theme + " theme to text field: " + placeholder);
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
