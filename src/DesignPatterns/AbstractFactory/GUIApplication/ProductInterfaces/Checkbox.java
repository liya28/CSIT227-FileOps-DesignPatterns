package DesignPatterns.AbstractFactory.GUIApplication.ProductInterfaces;

public interface Checkbox {
    void paint();
    void check();
    void uncheck();
    String getName();
    boolean isChecked();
    void setObserver(CheckboxObserver observer);
}
