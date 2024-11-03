package DesignPatterns.Adapter;

// Target interface

public interface Temperature {
    double getCelsius();
}

// Adaptee for Fahrenheit
class FahrenheitTemperature {
    private double fahrenheit;

    public FahrenheitTemperature(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }
}

// Adaptee for Kelvin
class KelvinTemperature {
    private double kelvin;

    public KelvinTemperature(double kelvin) {
        this.kelvin = kelvin;
    }

    public double getKelvin() {
        return kelvin;
    }
}

// Adapter for Fahrenheit

class FahrenheitAdapter implements Temperature {
    private FahrenheitTemperature fahrenheit;

    public FahrenheitAdapter(FahrenheitTemperature fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    @Override
    public double getCelsius() {
        return (fahrenheit.getFahrenheit() - 32) * 5 / 9;
    }
}

class KelvinAdapter implements Temperature {
    private KelvinTemperature kelvin;

    public KelvinAdapter(KelvinTemperature kelvin) {
        this.kelvin = kelvin;
    }

    @Override
    public double getCelsius() {
        return (kelvin.getKelvin()) - 273.15;
    }
}

// Client code
class TemperatureAdapterDemo {
    public static void main(String[] args) {
        FahrenheitTemperature fahrenheit = new FahrenheitTemperature(100);
        Temperature fahrenheitAdapter = new FahrenheitAdapter(fahrenheit);
        System.out.println("Fahrenheit to Celsius: " + fahrenheitAdapter.getCelsius());

        KelvinTemperature kelvin = new KelvinTemperature(300);
        Temperature kelvinAdapter = new KelvinAdapter(kelvin);
        System.out.println("Kelvin to Celsius: " + kelvinAdapter.getCelsius());
    }
}

