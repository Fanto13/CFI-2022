package lezione1201;

public class Rectangle implements Movable {
    Point lowerLeft;
    Point upperRight;

    public Rectangle(Point lowerLeft, Point upperRight) {
        this.lowerLeft = lowerLeft;
        this.upperRight = upperRight;
    }

    public Point getLowerLeft() {
        return lowerLeft;
    }

    public void setLowerLeft(Point lowerLeft) {
        this.lowerLeft = lowerLeft;
    }

    public Point getUpperRight() {
        return upperRight;
    }

    public void setUpperRight(Point upperRight) {
        this.upperRight = upperRight;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "lowerLeft=" + lowerLeft + ", upperRight=" + upperRight + '}';
    }

    public void move(double x, double y) {

    }

    public void translate(double x, double y) {
        this.upperRight.translate(x, y);
        this.lowerLeft.translate(x, y);
    }
}
