package week2;

public class CaesarCipher {
    public static String caesarCipher(String s, int k) {
        String a = "abcdefghijklmnopqrstuvwxyz";
        String b = a.toUpperCase();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c) && Character.isLowerCase(c)) {
                result += a.charAt((c - 'a' + k) % 26);
            } else if (Character.isAlphabetic(c) && Character.isUpperCase(c)) {
                result += b.charAt((c - 'A' + k) % 26);
            } else {
                result += c;
            }
        }
        return result;
    }
}
