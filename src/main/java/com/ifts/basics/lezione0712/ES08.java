package com.ifts.basics.lezione0712;


public class ES08 {

    public static double f(double n) {
        return 4.0 * (1 - (n/3) + (n/5) - (n/7) + (n/9) - (n/11));
    }

    public static void main(String[] args) {
        System.out.println(f(1));
    }
}
