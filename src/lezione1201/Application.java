package lezione1201;

public class Application {
    public static void main(String[] args) {
        Circle c = new Circle(new Point(2,3), 10);
        Rectangle r = new Rectangle(new Point(0,0), new Point(10,10));

        System.out.println(c);
        System.out.println(r);
    }
}
