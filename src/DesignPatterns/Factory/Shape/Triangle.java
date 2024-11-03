package DesignPatterns.Factory.Shape;

public class Triangle extends Shape {

    private double base, height, a, c;

    public Triangle(double base, double height, double a, double c, String color)
    {
        super(color);
        this.base = base;
        this.height = height;
        this.a = a;
        this.c = c;
    }

    @Override
    public double area()
    {
        double ans = base * height * 0.5;
        return ans;
    }

    @Override
    public double perimeter()
    {
        double ans = a + base + c;
        return ans;
    }

    public String toString()
    {
        return super.toString() + " which is also a Triangle";
    }

    public static class EquilateralTriangle extends Triangle {

        public EquilateralTriangle(double side, String color)
        {
            super(side, Math.sqrt(3) / 2 * side, side, side, color);
        }

        @Override
        public String toString()
        {
            return super.toString() + " which is also an Equilateral Triangle";
        }
    }
}