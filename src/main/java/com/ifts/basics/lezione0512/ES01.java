package com.ifts.basics.lezione0512;

public class ES01 {

    /*
    * a*x^2 + b*x + c = 0
    * a: coeff della x di secondo grado
    * b: coeff della x di primo grado
    * c: termine noto
    * */
    static void equazioneDiSecondoGrado(float a, float b, float c) {
        float delta = b*b - 4*a*c;

        if(a == 0) {
            System.out.println("a < 0! eq di grado 1");
        }
        else if (delta < 0) {
                System.out.println("DELTA NEGATIVO!");
        } else {
            float den = 2 * a;
            float x1 = -b + (float) Math.sqrt(delta) / den;
            float x2 = -b - (float) Math.sqrt(delta) / den;
            System.out.println(x1);
            System.out.println(x2);
        }
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 6;
        int c = 9;

        equazioneDiSecondoGrado(a,b,c);
    }
}
