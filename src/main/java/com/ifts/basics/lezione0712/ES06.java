package com.ifts.basics.lezione0712;


public class ES06 {

    public static double sum_first_n(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum_first_n(10));
    }
}
