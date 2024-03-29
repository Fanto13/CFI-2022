package com.ifts.basics.lezione1201;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ES01 {

    public static String readFirstLine(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(readFirstLine("cars.csv"));
    }
}
