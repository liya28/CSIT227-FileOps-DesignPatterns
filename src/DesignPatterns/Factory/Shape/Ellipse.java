package DesignPatterns.Factory.Shape;

public class Ellipse extends Shape {

    final double PI = 3.14159;
    private double a;
    private double b;

    public Ellipse(double a, double b, String color)
    {
        super(color);
        this.a = a;
        this.b = b;
    }

    @Override
    public double area()
    {
        return PI * a * b;
    }

    @Override
    public double perimeter()
    {
        double ans = PI * ((3 * (a + b)) - Math.sqrt((a + 3 * b) * (b + 3 * a)));
        return ans;
    }

    @Override
    public String toString()
    {
        return super.toString() + " which is also an Ellipse";
    }

    public static class Circle extends Ellipse {

        public Circle(double radius, String color)
        {
            super(radius, radius, color);
        }

        @Override
        public String toString()
        {
            return super.toString() + " which is also a Circle";
        }
    }
}