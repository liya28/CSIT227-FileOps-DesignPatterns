package DesignPatterns.Singleton;

public class Main {
    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();

        configManager.loadConfiguration();
        configManager.saveConfiguration();

        ConfigurationManager anotherConfig = ConfigurationManager.getInstance();
        System.out.println(configManager == anotherConfig);
    }
}
