package DesignPatterns.AbstractFactory.GUIApplication.ProductInterfaces;

public class ThemeManager {
    private String currentTheme;

    public void setTheme(String theme) {
        currentTheme = theme;
        System.out.println("Current theme: " + currentTheme);
    }

    public String getTheme() {
        return currentTheme;
    }
}
