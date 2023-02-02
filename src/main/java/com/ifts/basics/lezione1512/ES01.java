package com.ifts.basics.lezione1512;

public class ES01 {

    public static boolean isDivisible(int n, int d) {
        return n % d == 0;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int d = 2; d < n; d++) {
            if (isDivisible(n, d)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
}
