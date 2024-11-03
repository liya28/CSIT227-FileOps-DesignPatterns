package DesignPatterns.Factory;

interface Vehicle {
    String getSpecifications();
}

class Car implements Vehicle {
    @Override
    public String getSpecifications() {
        return "Type: Car, Wheels: 4, Fuel: Diesel";
    }
}

class Motorcycle implements Vehicle {
    @Override
    public String getSpecifications() {
        return "Type: Motorcycle, Wheels: 2, Fuel: Petrol";
    }
}

class Truck implements Vehicle {
    @Override
    public String getSpecifications() {
        return "Type: Truck, Wheels: 6, Fuel: Diesel";
    }
}

class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        switch (type) {
            case "Car": return new Car();
            case "Motorcycle": return new Motorcycle();
            case "Truck": return new Truck();
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getVehicle("Car");
        Vehicle motorcycle = VehicleFactory.getVehicle("Motorcycle");
        Vehicle truck = VehicleFactory.getVehicle("Truck");

        System.out.println(car.getSpecifications());
        System.out.println(motorcycle.getSpecifications());
        System.out.println(truck.getSpecifications());
    }
}
