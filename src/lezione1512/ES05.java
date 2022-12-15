package lezione1512;

import java.util.ArrayList;
import java.util.List;

public class ES05 {

    public static void digits(int n) {
        while (n > 0) {
            System.out.println(n % 10);
            n /= 10;
        }
    }

    public static boolean isArmstrongNumber(int n) {
        int sum = 0;
        int tmp = n;
        while (tmp > 0) {
            sum += Math.pow(tmp % 10, 3);
            tmp /= 10;
        }
        return (sum == n);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {
            if (isArmstrongNumber(i)) {
                System.out.println(i);
            }
        }
    }
}
