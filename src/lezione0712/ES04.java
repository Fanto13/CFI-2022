package lezione0712;


public class ES04 {

    public static double times_3(double a) {
        double r = a;
        r += a;
        r += a;
        return r;
    }

    public static double times_5(double a) {
        double r = a;
        r += a;
        r += a;
        r += a;
        r += a;
        return r;
    }

    public static double times_n(double a, int n) {
        double r = 0;

        int i = 0;
        while (i < n) {
            r = r + a;
            i = i + 1;
        }
        return r;
    }

    public static double divide_n(double a, int n) {
        int i = 0;
        while (a > 0) {
            a = a - n;
            i = i + 1;
        }
        return i - 1;
    }

    public static void main(String[] args) {
        double a = 7.1;

        System.out.println(times_3(a));
        System.out.println(times_5(a));
        System.out.println(times_n(a, 10));
        System.out.println(divide_n(16, 5));
    }
}
