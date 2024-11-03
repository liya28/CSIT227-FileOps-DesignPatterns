package DesignPatterns.Factory.Shape;

public abstract class Shape implements Comparable<Shape> {
    String color;

    public Shape(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "A shape that is color " + color;
    }

    public abstract double area();
    public abstract double perimeter();

    public int compareTo(Shape o) {
        if (color.compareTo(o.color) == 0) {
            if (area() < o.area()) {
                return 1;
            } else if (area() == o.area()) {
                return 0;
            } else {
                return -1;
            }
        }
        return color.compareTo(o.color);
    }

    public static class ShapeFactory {
        public static Shape createShape(String type, String color, double...dimensions) {
            return switch (type.toLowerCase()) {
                case "rectangle" -> new Rectangle(dimensions[0], dimensions[1], color);
                case "square" -> new Rectangle.Square(dimensions[0], color);
                case "ellipse" -> new Ellipse(dimensions[0], dimensions[1], color);
                case "circle" -> new Ellipse.Circle(dimensions[0], color);
                case "triangle" -> new Triangle(dimensions[0], dimensions[1], dimensions[2], dimensions[3], color);
                case "equilateral triangle" -> new Triangle.EquilateralTriangle(dimensions[0], color);
                default -> throw new IllegalArgumentException("Unknown type: " + type);
            };
        }
    }
}
