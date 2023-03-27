package com.ifts.basics.lezione1201.geometry;

public class Rectangle implements Movable, Computable {
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

    private double getWidth() {
        return upperRight.getX() - lowerLeft.getX();
    }

    private double getHeight() {
        return upperRight.getY() - lowerLeft.getY();
    }

    public void move(double x, double y) {
        double w = getWidth();
        double h = getHeight();
        lowerLeft.move(x, y);
        upperRight.move(x + w, y + h);
    }

    public void translate(double x, double y) {
        this.upperRight.translate(x, y);
        this.lowerLeft.translate(x, y);
    }

    @Override
    public double getArea() {
        return getWidth() * getHeight();
    }

    @Override
    public double getPerimeter() {
        return 2 * (getWidth() + getHeight());
    }
}
