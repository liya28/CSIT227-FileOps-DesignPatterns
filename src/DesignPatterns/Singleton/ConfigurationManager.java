package DesignPatterns.Singleton;

public class ConfigurationManager {
    private static ConfigurationManager instance;

    private ConfigurationManager() {
        System.out.println("Loading configuration settings...");
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void loadConfiguration() {
        System.out.println("Configurations loaded.");
    }

    public void saveConfiguration() {
        System.out.println("Configurations saved.");
    }
}
