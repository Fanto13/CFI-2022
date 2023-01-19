package lezione2212;

import java.util.HashMap;
import java.util.Map;

public class ES05 {
    public static String getColor(int color) {
        if (color == 0) {
            return "black";
        } else if (color == 1) {
            return "white";
        } else {
            return "red";
        }
    }

    public static String getColorWithMap(int color) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "black");
        map.put(1, "white");
        if (!map.containsKey(color)) {
            return "red";
        }
        return map.get(color);
    }

    public static void main(String[] args) {
        System.out.println(getColor(1));
    }
}
