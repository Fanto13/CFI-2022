package lezione1201;

public class Rectangle {
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
}
