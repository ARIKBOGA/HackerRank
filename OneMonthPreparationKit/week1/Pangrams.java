package week1;

public class Pangrams {
    public static String pangrams(String s) {
        int i = 0;
        char c = 'a';
        s = s.replaceAll(" ", "").toLowerCase();
        while (s.contains(String.valueOf(c))) {
            i++;
            c++;
        }
        return i == 26 ? "pangram" : "not pangram";
    }
}