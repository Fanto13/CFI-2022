package com.ifts.basics.lezione2212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ES02 {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("nicola");
        l.add("nicola");
        l.add("luisa");
        l.add("nicola");
        l.add("giulia");
        System.out.println(l);
        l = new ArrayList<>(new HashSet<>(l));
    }
}
