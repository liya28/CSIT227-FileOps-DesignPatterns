package DesignPatterns.Factory.Shape;
import java.util.*;

public class ShapeMain {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            List<Shape> shapes = new ArrayList<>();
            String shape, color = "";
            double[] dimensions = new double[0];
            do {
                System.out.print("Enter shape: ");
                shape = sc.nextLine();

                if (shape.equals("DONE")) { break; }

                switch (shape.toLowerCase()) {

                    case "rectangle":
                        dimensions = new double[2];
                        System.out.print("Enter length: ");
                        dimensions[0] = sc.nextDouble();
                        System.out.print("Enter width: ");
                        dimensions[1] = sc.nextDouble();
                        sc.nextLine();
                        break;

                    case "square":
                        dimensions = new double[1];
                        System.out.print("Enter side: ");
                        dimensions[0] = sc.nextDouble();
                        sc.nextLine();
                        break;

                    case "ellipse":
                        dimensions = new double[2];
                        System.out.print("Enter a: ");
                        dimensions[0] = sc.nextDouble();
                        System.out.print("Enter b: ");
                        dimensions[1] = sc.nextDouble();
                        sc.nextLine();
                        break;

                    case "circle":
                        dimensions = new double[1];
                        System.out.print("Enter radius: ");
                        dimensions[0] = sc.nextDouble();
                        sc.nextLine();
                        break;

                    case "triangle":
                        dimensions = new double[4];
                        System.out.print("Enter base: ");
                        dimensions[0] = sc.nextDouble();
                        System.out.print("Enter height: ");
                        dimensions[1] = sc.nextDouble();
                        System.out.print("Enter a: ");
                        dimensions[2] = sc.nextDouble();
                        System.out.print("Enter c: ");
                        dimensions[3] = sc.nextDouble();
                        sc.nextLine();
                        break;

                    case "equilateral triangle":
                        dimensions = new double[1];
                        System.out.print("Enter side: ");
                        dimensions[0] = sc.nextDouble();
                        sc.nextLine();
                        break;

                    default:
                        System.out.println("Unknown shape type. Try again.");
                        continue;
                }

                System.out.print("Enter color: ");
                color = sc.nextLine();

                Shape sh = Shape.ShapeFactory.createShape(shape, color, dimensions);
                shapes.add(sh);
            } while (!shape.equalsIgnoreCase("DONE"));

            String task;

            do {

                System.out.print("Sort by: ");
                task = sc.nextLine();

                switch (task.toLowerCase()) {
                    case "done":
                        break;

                    case "color":
                        Collections.sort(shapes);
                        for (Shape s : shapes) {
                            System.out.print("Area of " + s + ": ");
                            System.out.format("%.2f\n", s.area());
                        }
                        break;
                    case "area":
                        shapes.sort(new ShapeAreaComparator());
                        for (Shape s : shapes) {
                            System.out.print("Area of " + s + ": ");
                            System.out.format("%.2f\n", s.area());
                        }
                        break;
                    case "perimeter":
                        shapes.sort(new ShapePerimeterComparator());
                        for (Shape s : shapes) {
                            System.out.print("Perimeter of " + s + ": ");
                            System.out.format("%.2f\n", s.perimeter());
                        }
                        break;
                }

            } while (!task.equalsIgnoreCase("DONE"));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
