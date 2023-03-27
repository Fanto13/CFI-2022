package com.ifts.basics.lezione0712;

import java.util.Scanner;

public class ES03 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Inserisci un numero intero: ");
        int a = scr.nextInt();
        System.out.print("Inserisci un numero intero: ");
        int b = scr.nextInt();
        System.out.print("Inserisci un numero intero: ");
        int c = scr.nextInt();

        System.out.println("Massimo fra " + a + "," + b + "," + c + " = " + max_better(a, b, c));
    }

    public static int max(int a, int b, int c) {
        int r = a;
        if (a > b) {
            if (a > c) {
                r = a;
            }
        } else if (b > c) {
            r = b;
        } else {
            r = c;
        }
        return r;
    }

    public static int max_better(int a, int b, int c) {
        if (a > b && a > c) return a;
        if (b > a && b > c) return b;
        return c;
    }
}
