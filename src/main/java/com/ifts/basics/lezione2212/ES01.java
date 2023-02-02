package com.ifts.basics.lezione2212;

import java.util.*;

public class ES01 {
    public static double testCollection(Collection c, int size) {
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            c.add(i);
        }

        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            c.contains(rnd.nextInt(size));
        }
        long stop = System.nanoTime();
        return (double)(stop - start) / 1000000.0;
    }

    public static void main(String[] args) {
        Set<Integer> hs = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        System.out.println(testCollection(hs, 100000));
    }
}
