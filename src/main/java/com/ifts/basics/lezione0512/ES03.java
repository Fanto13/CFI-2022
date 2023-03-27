package com.ifts.basics.lezione0512;

public class ES03 {
    public static void main(String[] args) {
        int a = 1;
        int b = 3;

        a = 12;

        b = a; // b assume il valore di a
        a = 7; // b NON ha cambiato nuovamente valore assieme ad a

        final int costante = a; // non sarà più possibile assegnare un nuovo valore
        // costante = 5;

        final int pippo;
        pippo = 5; // il primo assegnamento è detto inizializzazione ed è consentito
    }
}
