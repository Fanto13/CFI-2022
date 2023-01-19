package lezione1212;

import java.util.Scanner;

public class ES01 {

    static void stampaArray(int[] v) {
        for(int i = 0; i < v.length; i++) {
            System.out.println("Elemento " + i + ": " + v[i]);
        }
    }

    static void inizializzaArraySequenziale(int[] v) {
        for(int i = 0; i < v.length; i++) {
            v[i] = i;
        }
    }

    static void inizializzaArrayRandom(int[] v) {
        for (int i = 0; i < v.length; i++) {
            // Math.random() --> [0;1[
            // Math.random() * 1000 --> [0;1000[
            v[i] = (int)(Math.random()*1000);
        }
    }

    static void inizializzaArrayScanner(int[] v) {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < v.length; i++) {
            System.out.println("Inserisci il " + (i+1) + "° numero:");
            v[i] = s.nextInt();
        }
    }

    public static void main(String[] args) {
        int[] v = new int[10];

        // [ 0 1 2 3 4 5 ]
        // l'array v viene modificato dalla funzione
        //inizializzaArraySequenziale(v);
        //inizializzaArraySequenziale_return(v);

        //inizializzaArrayRandom(v);

        inizializzaArrayScanner(v);
        stampaArray(v);

    }
}
