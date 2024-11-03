package DesignPatterns.AbstractFactory.GUIApplication.ProductInterfaces;

public interface Button {
    void paint();
    void setAction(Runnable action);
    String getName();
    void click();
}
