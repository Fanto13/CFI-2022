package com.ifts.basics.lezione0512;

import java.util.Scanner;

public class ES04_whatsapps1 {

    public static void main(String[] args) {

        // chiedere all'utente di inserire un numero di telefono corretto (10 cifre o 9 se comincia con 0)
        // numeri con prefissi a tre cifre come Bologna (051 e non 0532) non sono da considerare validi
        // solo se l'input è corretto richiedere il messaggio da inviare e stampare a video i dati inseriti

        System.out.println("Inserire numero di telefono:");
        Scanner scanner = new Scanner(System.in);

        long numero = scanner.nextLong();
        scanner.nextLine();

        if(numero >= 100000000 && numero <= 9999999999l) {
            System.out.println("Inserire messaggio:");
            String messaggio = scanner.nextLine();

            System.out.println(numero);
            System.out.println(messaggio);
        }
        else {
            System.out.println("ERRORE!");
        }
    }
}
