package com.ifts.basics.lezione1212;

public class ES06 {

    public static void main(String[] args) {
        String[] carrello = {"Mela", "Pera", "Arancia", "Pera", "Kiwi", "mela"};

        // contare quanti frutti siano unici nel carrello
        // stampare a video i frutti unici

        for(int i = 0; i < carrello.length; i++) {
            // il primo loop sceglie ogni elemento nel carrello

            int conteggio = 0;

            for(int j = 0; j < carrello.length; j++) {
                // il secondo loop conta quanti elementi uguali sono presenti

                String a = carrello[i].toLowerCase();
                String b = carrello[j].toLowerCase();

                if(a.equals(b)) {
                    conteggio++;
                }
            }

            if(conteggio == 1) {
                System.out.println(carrello[i]);
            }
        }
    }
}
