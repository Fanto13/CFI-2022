package lezione0512;

import java.util.Scanner;

public class ES05_whatsapp2 {
    public static void main(String[] args) {

        // modificare ES04 e gestire i numeri telefonici con prefisso internazionale

        // Dichiarazione
        String numero;
        String messaggio;
        String prefix;
        long numeroNumerico;

        // Inizializzazione
        String numeroSenzaPrefisso = "";
        Scanner scanner = new Scanner(System.in);

        // Utilizzo
        System.out.println("Inserire numero di telefono: ");
        numero = scanner.nextLine();

        if(numero.length() < 10) {
            System.out.println("ERRORE numero troppo corto!");
            return; // la funzione termina qui, avere molteplici uscite da una funzione non sempre è la cosa giusta
        }
        if(numero.length() > 10) {
            char plus = numero.charAt(0);
            if (plus != '+') { // un solo apice non è una stringa ma un char
                System.out.println("ERRORE + !");
                return;
            }

            // nella stringa "012345" ogni carattere indica la sua posizione '0' -> 0   '1' -> 1  ...  '5' -> 5
            prefix = numero.substring(1,3); // parte dal carattere in posizione 1 e arriva al carattere prima della posizione 3
            System.out.println("Il prefisso è: " + prefix);

            numeroSenzaPrefisso = numero.substring(3); // 3 è la posizione, non il carattere
            numeroSenzaPrefisso = numeroSenzaPrefisso.trim(); // rimuove i white space prima e dopo la stringa
        }

        // Eseguo solo se il programma ha un numero corretto in input
        System.out.println("Inserire messaggio: ");
        messaggio = scanner.nextLine();

        // Stampo a video i dati
        System.out.println(numero);
        System.out.println(messaggio);

        numeroNumerico = Long.parseLong(numeroSenzaPrefisso);
        System.out.println(numeroNumerico);
    }
}
