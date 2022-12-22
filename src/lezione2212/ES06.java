package lezione2212;

import java.util.HashSet;
import java.util.Set;

public class ES06 {

    public static Set<Integer> intersection_manual(Set<Integer> first, Set<Integer> second) {
        Set<Integer> intersection = new HashSet<>();
        for (int i : first) {
            if (second.contains(i)) {
                intersection.add(i);
            }
        }
        return intersection;
    }

    public static Set<Integer> union_manual(Set<Integer> first, Set<Integer> second) {
        Set<Integer> union = new HashSet<>();
        for (int i : first) {
            union.add(i);
        }
        for (int i : second) {
            union.add(i);
        }
        return union;
    }

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Set.of(23, 45, 11, 22, 88));
        Set<Integer> s2 = new HashSet<>(Set.of(11, 22, 63, 78, 37));
        System.out.println(intersection_manual(s1, s2));
        System.out.println(union_manual(s1, s2));
    }
}
