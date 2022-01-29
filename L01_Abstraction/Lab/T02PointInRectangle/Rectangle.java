package M04_JavaOOP.L01_Abstraction.Lab.T02PointInRectangle;

public class Rectangle {
    private final Point pointA;
    private final Point pointB;

    public Rectangle(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public boolean isInside(Point p) {
        return p.isGreaterThanOrEqual(pointA) &&
                p.isLessThanOrEqual(pointB);
    }
}
