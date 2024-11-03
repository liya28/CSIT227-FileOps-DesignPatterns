package DesignPatterns.Factory.Shape;
import java.util.Comparator;

public class ShapeAreaComparator implements Comparator<Shape> {
    public int compare(Shape a, Shape b) {
        return Double.compare(b.area(), a.area());
    }
}
