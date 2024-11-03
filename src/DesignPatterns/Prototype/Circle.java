package DesignPatterns.Prototype;

import java.util.ArrayList;
import java.util.List;

public class Circle implements Shape {
    private int radius;
    private String color;
    private List<String> circle_users;

    public Circle(int radius, String color, List<String> circle_users) {
        this.radius = radius;
        this.color = color;
        this.circle_users = new ArrayList<>(circle_users);
    }

    @Override
    public Circle clone() {
        try {
            Circle c = (Circle)super.clone();
            c.circle_users = new ArrayList<>(this.circle_users);
            return c;
        } catch(CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle with radius" + radius);
    }
}
