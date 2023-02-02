package com.ifts.basics.lezione1212;

public class ES03 {

    static void stampaArray(int[] v) {
        for(int i = 0; i < v.length; i++) {
            System.out.println("Elemento " + i + ": " + v[i]);
        }
    }

    static void inizializzaArrayRandom(int[] v) {
        for (int i = 0; i < v.length; i++) v[i] = (int)(Math.random()*1000);

        /*
        int i = 0;
        while(i < v.length) {
            v[i] = (int)(Math.random()*1000);

            i++;
        }
         */
    }

    static boolean isSorted(int[] v) { // in maniera crescente
        // l'ordine viene dato per scontato
        boolean sorted = true;
        for(int i = 0; i < v.length - 1; i++) {
            if(v[i] > v[i+1]) {
                // un solo elemento fuori posto interrompe il tutto
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        int v[] = new int[10];

        inizializzaArrayRandom(v);


        for (int i = 0; i < v.length - 1; i++) {     // per ogni elemento, ultimo escluso
            for (int j = i + 1; j < v.length; j++) { // lo confronto con tutti gli elementi dopo di lui
                                                     // dando per scontato che i precedenti siano già ordinati
                if(v[i] > v[j]) {
                    int tmp = v[i];
                    v[i] = v[j];
                    v[j] = tmp;
                }
            }
        }


        stampaArray(v);
    }
}
