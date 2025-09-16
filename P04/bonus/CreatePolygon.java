package P04.bonus;

import P04.bonus.Polygon;

import java.util.Scanner;

public class CreatePolygon {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Enter a polygon using x y points (Ctrl -d or Ctr -x to finish):");

        Polygon polygon = new Polygon();

        while (in.hasNextDouble()) {
            double x = in.nextDouble();
            double y = in.nextDouble();

            Point point = new Point(x, y);

            polygon.addPoint(point);
            System.out.println("Added point " + point);
        }

        System.out.println(polygon.toString() + " has perimeter " + polygon.perimeter());
    }
}
