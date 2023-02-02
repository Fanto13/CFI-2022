package com.ifts.basics.lezione1212;

public class ES05 {

    static int dimezzaFinoPari(int x) {
        // prende in input un intero
        // lo dimezza molteplici volte
        // fin quando la divisione non da risultato pari

        while(true) {
            x = x / 2;
            if(x % 2 == 0){
                break;
            }
        }

        return x;
    }

    static int collatz(int x) {
        while (x > 1) {
            System.out.print(""+x+" ");
            if(x % 2 == 0) { // verifica se è pari
                x /= 2;
                // x = x / 2;
            }
            else {
                x = x * 3 + 1;
            }
        }

        return x;
    }

    public static void main(String[] args) {
        // main di prova
        int[] x = {71,100,25,99,1351};
        for(int i = 0; i< x.length; i++) {
            //int res = dimezzaFinoPari(x[i]);
            int res = collatz(x[i]);
            System.out.println(res);
        }
    }
}
