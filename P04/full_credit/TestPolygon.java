package P04.full_credit;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class TestPolygon {
    private static Scanner in = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {
        int errorCode = 0;
        try {
            System.out.println("Test 1");
            Polygon polygon = new Polygon();
            polygon.addPoint(new Point(0, 0));
            polygon.addPoint(new Point(3, 0));
            polygon.addPoint(new Point(3, 4));
            if (polygon.perimeter() == 12) {
                System.out.println("Perimeter is correct");
            } else {
                errorCode = -1;
                System.out.println("Perimeter is not correct");
            }

            System.out.println("Test 2");
            try {
                Polygon polygon2 = new Polygon();
                polygon2.addPoint(new Point(0, 0));
                polygon2.addPoint(new Point(3, 0));
                polygon2.addPoint(new Point(0, 0));
            } catch (IllegalArgumentException e) {
                errorCode = -1;
                System.out.println(e.getMessage());
            }

            System.out.println("Test 3");
            try {
                Polygon polygon3 = new Polygon();
                polygon3.addPoint(new Point(0, 0));
                polygon3.addPoint(new Point(3, 0));

                polygon3.perimeter();
            } catch (RuntimeException e) {
                errorCode = -1;
                System.out.println(e.getMessage());
            }

            System.out.println("Test 4");
            try {
                Polygon polygon4 = new Polygon();
                for (int i = 0; i < 13; i++) {
                    polygon4.addPoint(new Point(rand.nextDouble(), rand.nextDouble()));
                }
            } catch (IllegalArgumentException e) {
                errorCode = -1;
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Unexpected exception during test");
        }

        if (errorCode != 0) {
            System.out.println(errorCode);
        }

    }
}
