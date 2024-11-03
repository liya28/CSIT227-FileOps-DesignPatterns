package DesignPatterns.AbstractFactory.GUIApplication.ConcreteProducts;

import DesignPatterns.AbstractFactory.GUIApplication.ProductInterfaces.Checkbox;
import DesignPatterns.AbstractFactory.GUIApplication.ProductInterfaces.CheckboxObserver;

public class WindowsCheckbox implements Checkbox {
    private String name;
    private String theme;
    private boolean checked = false;
    private CheckboxObserver observer;

    public WindowsCheckbox(String name, String theme) {
        this.name = name;
        this.theme = theme;
    }

    @Override
    public void paint() {
        System.out.println("Applying " + theme + " theme to checkbox: " + name);
    }

    @Override
    public void check() {
        checked = true;
        if (observer != null) observer.update(this);
        System.out.println("Checkbox state changed: checked");
    }

    @Override
    public void uncheck() {
        checked = false;
        if (observer != null) observer.update(this);
        System.out.println("Checkbox state changed: unchecked");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isChecked() {
        return checked;
    }

    public void setObserver(CheckboxObserver observer) {
        this.observer = observer;
    }
}
