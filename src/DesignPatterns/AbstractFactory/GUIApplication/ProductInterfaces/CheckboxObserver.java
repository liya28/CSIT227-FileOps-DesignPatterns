package DesignPatterns.AbstractFactory.GUIApplication.ProductInterfaces;

public class CheckboxObserver implements Observer {
    @Override
    public void update(Checkbox checkbox) {
        System.out.println("Checkbox " + checkbox.getName() + " state changed to: " + ((checkbox.isChecked() ? "checked" : "unchecked")));
    }
}
