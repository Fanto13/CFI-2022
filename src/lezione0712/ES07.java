package lezione0712;


public class ES07 {

    public static double abs(double n) {
        if (n < 0.0) return (-1) * n;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(abs(-10.2));
    }
}
