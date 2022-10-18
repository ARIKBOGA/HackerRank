package week1;

import java.util.ArrayList;
import java.util.List;

public class Pangrams {

    public static boolean pangrams(String s) {
        int i = 0;
        char c = 'a';
        s = s.replaceAll(" ", "").toLowerCase();
        while (s.contains(String.valueOf(c))) {
            i++;
            c++;
        }
        return i == 26;
    }

    public static boolean pangrams_2(String s) {
        return 26 == s.replaceAll(" ", "")
                .chars()
                .distinct()
                .count();
    }

    public static String isPangram(List<String> list) {
        String result = "";
        for (String each : list) {
            result += pangrams_2(each) ? "1" : "0";
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("We promptly judged antique ivory buckles for the prize");
        list.add("We promptly judged antique ivory buckles for the next prize");
        list.add("abcdefghijklmnoprstuvyzqxw");

        System.out.println(isPangram(list));
    }
}