package com.ifts.basics.lezione1201.geometry;

public class Application {
    public static void main(String[] args) {
        Point p = new Point(2,3);
        Circle c = new Circle(new Point(2,3), 10);
        Rectangle r = new Rectangle(new Point(0,0), new Point(10,10));

        Movable m = r;

        if (m instanceof Circle) {
            Circle c2 = (Circle) m;
            c2.getArea();
        }






        System.out.println(p);
        System.out.println(c);
        System.out.println(r);
    }
}
