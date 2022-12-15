package lezione1512;

import java.util.ArrayList;
import java.util.List;

public class ES05 {

    public static int[] digits(int n) {
        List<Integer> l = new ArrayList<>();
        while (n > 0) {
            l.add(n % 10);
            n /= 10;
        }
        return toIntArray(l);
    }

    public static int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        for(int i = 0; i < ret.length; i++)
            ret[i] = list.get(i);
        return ret;
    }

    public static boolean isArmstrongNumber(int n) {
        return true;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {
            if (isArmstrongNumber(i)) {
                System.out.println(i);
            }
        }
    }
}
