package DesignPatterns.Factory.Shape;
import java.util.Comparator;

public class ShapePerimeterComparator implements Comparator<Shape> {
    public int compare(Shape a, Shape b) {
        return Double.compare(b.perimeter(), a.perimeter());
    }
}
