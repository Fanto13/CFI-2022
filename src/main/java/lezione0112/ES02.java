package lezione0112;

public class ES02 {

    public static int lenght(String s) {
        return s.length();
    }

    public static String repeat(String s, int count) {
        return s.repeat(count);
    }

    public static String substitute(String s, char oldc, char newc) {
        return s.replace(oldc, newc);
    }

    public static String lower(String s) {
        return s.toLowerCase() + s.length();
    }

    public static void main(String[] args) {
        String s = "NIcola";

        System.out.println(lenght(s));
        System.out.println(repeat(s,5));
        System.out.println(substitute(s, 'n', 'q'));
        System.out.println(lower(s));
    }
}
