package com.ifts.basics.lezione1512;

public class ES03 {

    public static boolean isPerfect(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return (sum == n);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 1000000; i++) {
            if (i % 50000 == 0) {
                System.out.println(i + "...");
            }

            if (isPerfect(i)) {
                System.out.println(i);
            }
        }
    }
}
