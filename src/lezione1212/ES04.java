package lezione1212;

import java.util.Scanner;

public class ES04 {

    static void task() {
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci una parola: ");
        String parola = s.nextLine();
        parola = parola.toUpperCase();
        System.out.println(parola);
    }

    public static void main(String[] args) {
        while(true) {
            task();

            System.out.println("Continuare?");
            Scanner s = new Scanner(System.in);
            String risposta = s.nextLine();

            if("no".equals(risposta)) {
                break;
            }
        }

        /*
        for (;;) {
            task();

            System.out.println("FORContinuare?");
            Scanner s = new Scanner(System.in);
            String risposta = s.nextLine();

            if ("no".equals(risposta)) {
                break;
            }
        }
         */
    }
}
