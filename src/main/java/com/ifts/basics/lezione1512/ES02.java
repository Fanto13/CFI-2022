package com.ifts.basics.lezione1512;

public class ES02 {
    public static boolean isDivisible(int n, int d) {
        return n % d == 0;
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int d = 2; d < n; d++) {
            if (isDivisible(n, d)) {
                return false;
            }
        }
        return true;
    }

    public static int countSpecialCouples(int maxValue, int distance) {
        int count = 0;
        for (int i = 1; i < maxValue; i++) {
            if (isPrime(i) && isPrime(i + distance)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSpecialCouples(1000, 2));
        System.out.println(countSpecialCouples(1000, 4));
        System.out.println(countSpecialCouples(1000, 6));
    }
}
