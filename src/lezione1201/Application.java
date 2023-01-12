package lezione1201;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Point p = new Point(2,3);
        Circle c = new Circle(new Point(2,3), 10);
        Rectangle r = new Rectangle(new Point(0,0), new Point(10,10));

        List<Movable> l = new ArrayList<>();
        l.add(p);
        l.add(c);
        l.add(r);

        System.out.println(p);
        System.out.println(c);
        System.out.println(r);

        for (Movable m : l) {
            m.translate(1,1);
        }

        System.out.println(p);
        System.out.println(c);
        System.out.println(r);
    }
}
