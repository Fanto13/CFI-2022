package lezione0712;


public class ES05 {

    public static double times_n(double a, int n) {
        double r = 0;
        for (int i = 0; i < n; i++) {
            r += a;
        }
        return r;
    }

    public static double divide_n(double a, int n) {
        int i;
        for (i = 0; a >= 0; i++) {
            a -= n;
        }
        return i - 1;
    }

    public static void main(String[] args) {
        double a = 7.1;

        System.out.println(times_n(a, 10));
        System.out.println(divide_n(16, 5));
    }
}
