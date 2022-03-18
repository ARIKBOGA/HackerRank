package week1;

import java.util.Scanner;

public class XORStrings_2 {
    public static String stringsXOR(String s, String t) {
        String res = new String("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i))
                res += "1";
            else
                res += "0";
        }

        return res;
    }

    public static void main(String[] args) {
        String s, t;
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        t = in.nextLine();
        System.out.println(stringsXOR(s, t));
    }
}