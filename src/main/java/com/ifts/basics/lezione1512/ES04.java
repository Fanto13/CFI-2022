package com.ifts.basics.lezione1512;

public class ES04 {

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
