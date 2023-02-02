package com.ifts.basics.lezione0712;

import java.util.Scanner;

public class ES02 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Inserisci un numero intero: ");
        int a = scr.nextInt();
        System.out.print("Inserisci un numero intero: ");
        int b = scr.nextInt();

        System.out.println("Massimo fra " + a + " e " + b + " = " + max(a, b));
    }

    public static int max(int a, int b) {
        int r;
        if (a > b) {
            r = a;
        } else {
            r = b;
        }
        return r;
    }
}
