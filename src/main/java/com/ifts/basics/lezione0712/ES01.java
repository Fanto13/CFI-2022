package com.ifts.basics.lezione0712;

import java.util.Scanner;

public class ES01 {
    public static void main(String[] args) {
        System.out.print("Inserisci un nome: ");
        Scanner scr = new Scanner(System.in);
        String name = scr.next();
        if (name.equals("nicola")) {
            System.out.println(sayHello());
        } else {
            System.out.println(sayGoAway());
        }
    }

    public static String sayHello() {
        return "Hello!";
    }

    public static String sayGoAway() {
        return "Go Away!";
    }
}
