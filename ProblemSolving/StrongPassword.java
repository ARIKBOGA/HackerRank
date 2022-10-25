import java.util.Arrays;
import java.util.List;

public class StrongPassword {

    /*
            numbers = "0123456789"
            lower_case = "abcdefghijklmnopqrstuvwxyz"
            upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            special_characters = "!@#$%^&*()-+"

     */

    private final static List<Character> specials = Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+');

    private static boolean containsUpperCase(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c))
                return true;
        }
        return false;
    }

    private static boolean containsLowerCase(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c))
                return true;
        }
        return false;
    }

    private static boolean containsDigit(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    private static boolean containsSpecial(String s) {
        for (char c : s.toCharArray()) {
            if (specials.contains(c))
                return true;
        }
        return false;
    }

    public static int minimumNumber(int n, String password) {

        int count = 0;

        if (!containsUpperCase(password)) count++;
        if (!containsLowerCase(password)) count++;
        if (!containsDigit(password)) count++;
        if (!containsSpecial(password)) count++;

        return Math.max(count, 6 - n);

    }


    public static void main(String[] args) {
        System.out.println("minimumNumber(11,\"#HackerRank\") = " + minimumNumber(11, "#HackerRank"));
        System.out.println("minimumNumber(3,\"Ab1\") = " + minimumNumber(3, "Ab1"));
    }
}
