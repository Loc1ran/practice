package P04.bonus;

public class Polygon {
    private static final int MAX_SIDES = 12;
    private int numSides;
    private Point[] points = new Point[MAX_SIDES];

    public Point[] addPoint(Point point){
        for (int i = 0; i < numSides; i++) {
            if (points[i].equals(point)){
                throw new IllegalArgumentException("Duplicate point " + point);
            }
        }
        try {
            points[numSides++] = point;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Polygon is full");
        }

        return points;
    }

    public double perimeter(){
        if ( numSides < 3 ){
            throw new RuntimeException("Polygon require 3+ sides!");
        }

        double perimeter = 0;

        for (int i = 0; i < numSides - 1; i++) {
            perimeter += lineLength(points[i], points[i+1]);
        }

        perimeter += lineLength(points[numSides - 1], points[0]);

        return perimeter;
    }

    @Override
    public String toString() {
        String result = "Polygon [";
        for (int i = 0; i < numSides; i++) {
            result += points[i].toString();
            if (i < numSides-1) {
                result += ", ";
            }
        }

        return result + "]";
    }

    private static double lineLength(Point p1, Point p2){
        double x = p2.getX() - p1.getX();
        double y = p2.getY() - p1.getY();

        return Math.sqrt(x * x + y * y);
    }


}
