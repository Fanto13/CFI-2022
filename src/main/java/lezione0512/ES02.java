package lezione0512;

import java.util.Scanner;

public class ES02 {
    public static void main(String[] args) {

        /*
         0  1  2  3  4  5
        [ ][ ][ ][ ][ ]...
         */
        int[] arr = new int[5]; // int a,b,c,d,e,f

        arr[0] = 10;
        arr[1] = 5;
        arr[2] = 2;
        arr[3] = 14;
        arr[4] = 100;
        //arr[5] = -1;

        //System.out.println(arr[2]);

        // le stringhe hanno un metodo .length()
        // gli array hanno un attributo .length
        for( int i = 0 ; i < arr.length ; i++ ) {
            System.out.println(arr[i]);
        }

        Scanner s = new Scanner(System.in);

        for( int i = 0 ; i < arr.length ; i++ ) {
            System.out.println("Numero:");
            arr[i] = s.nextInt();
        }
        for( int i = 0 ; i < arr.length ; i++ ) {
            System.out.println(arr[i]);
        }
    }
}
