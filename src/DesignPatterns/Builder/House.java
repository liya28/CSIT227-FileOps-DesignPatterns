package DesignPatterns.Builder;


public class House {
    private int rooms;
    private int bathrooms;
    private boolean hasGarage;
    private String color;

    private House(HouseBuilder builder) {
        this.rooms = builder.rooms;
        this.bathrooms = builder.bathrooms;
        this.hasGarage = builder.hasGarage;
        this.color = builder.color;
    }

    public static class HouseBuilder {
        private int rooms;
        private int bathrooms = 1;
        private boolean hasGarage = false;
        private String color = "White";

        public HouseBuilder(int rooms) {
            this.rooms = rooms;
        }

        public HouseBuilder bathrooms(int bathrooms) {
            this.bathrooms = bathrooms;
            return this;
        }

        public HouseBuilder hasGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public HouseBuilder color(String color) {
            this.color = color;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }

    @Override
    public String toString() {
        return "House{" +
                "rooms = " + rooms +
                ", bathrooms = " + bathrooms +
                ", hasGarage = " + hasGarage +
                ", color= '" + color + '\'' +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        House house1 = new House.HouseBuilder(3).build();
        System.out.println(house1);

        House house2 = new House.HouseBuilder(4)
                .hasGarage(true)
                .color("Blue")
                .build();
        System.out.println(house2);

        House house3 = new House.HouseBuilder(2)
                .bathrooms(2)
                .build();
        System.out.println(house3);
    }
}

