package lezione0112;

public class ES01 {
    public static double sum(double a, double b) {
        return a + b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }

    public static double mul(double a, double b) {
        return a * b;
    }

    public static double div(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        double a = 4;
        double b = 3;

        System.out.println(sum(a, b));
        System.out.println(sub(a, b));
        System.out.println(mul(a, b));
        System.out.println(div(a, b));
    }
}