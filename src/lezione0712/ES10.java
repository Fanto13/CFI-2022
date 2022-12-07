package lezione0712;

import java.util.Scanner;

public class ES10 {

    public static void main(String[] args) {
        int n = 0;
        Scanner scr = new Scanner(System.in);

        while (n < 1 || n > 10) {
            System.out.print("Insert a number [1, 10]: ");
            n = scr.nextInt();
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " X " + i + " = " + n * i);
        }
    }
}
