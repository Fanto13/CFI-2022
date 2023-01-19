package lezione1212;

public class ES02 {
    static void inizializzaArraySequenziale(int[] v) {
        for(int i = 0; i < v.length; i++) {
            v[i] = i;
        }
    }

    static void raddoppiaValoriArray(int[] v) {
        for(int i = 0; i < v.length; i++) {
            v[i] = v[i] * 2;
        }
    }

    static int sommaValoriArray(int[] v) {
        int somma = 0;
        for(int i = 0; i < v.length; i++) { // per ogni valore nell'array
            somma += v[i];
        }
        return somma;
    }

    static double mediaValoriArray(int[] v) {
        double somma = sommaValoriArray(v);
        return somma / v.length;
    }

    static int massimoArray(int[] v) {
        int max = v[0];
        //int max = Integer.MIN_VALUE;

        for(int i = 1; i < v.length; i++) {
            if(v[i] > max) {
                max = v[i];
            }
        }

        return max;
    }


    static int minimoArray(int[] v) {
        int min = v[0];
        //int min = Integer.MAX_VALUE;

        for(int i = 1; i < v.length; i++) {
            if(v[i] < min) {
                min = v[i];
            }
        }

        return min;
    }

    static void stampaArray(int[] v) {
        for(int i = 0; i < v.length; i++) {
            System.out.println("Elemento " + i + ": " + v[i]);
        }
    }

    public static void main(String[] args) {
        int v[] = new int[10];

        inizializzaArraySequenziale(v);

        //raddoppiaValoriArray(v);
        stampaArray(v);

        int somma = sommaValoriArray(v); // ritorna int
        System.out.println("La somma dei valori è: " + somma);

        double media = mediaValoriArray(v); // ritorna double o float
        System.out.println("La media dei valori è: " + media);

        int max = massimoArray(v);
        System.out.println("Il massimo dei valori è: " + max);

        //minimoArray(v);
    }
}
