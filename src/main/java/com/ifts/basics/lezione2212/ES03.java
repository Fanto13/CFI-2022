package com.ifts.basics.lezione2212;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class ES03 {
    public static List<String> readCars(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            for (;;) {
                String line = br.readLine();
                if (line == null) break;
                lines.add(line);
            }
        }
        return new ArrayList(new LinkedHashSet(lines));
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = readCars("cars.csv");
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
