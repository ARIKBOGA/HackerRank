import java.math.BigInteger;

public class RomanNumbers {
    private static final String[] belowTen = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    /*public static String intToRoman(int num) {
        int bin = num / 1000;
        num %= 1000;

        int yuz = num / 100;
        num %= 100;

        int on = num / 10;
        num %= 10;

        String str = "";

        str = str.concat("M".repeat(bin));

        if (yuz == 5) {
            str = str.concat("D");
        } else if (yuz == 4) {
            str = str.concat("CD");
        } else if (yuz < 4) {
            str = str.concat("C".repeat(yuz));
        } else if (yuz < 9) {
            str = str.concat("D");
            str = str.concat("C".repeat(yuz - 5));
        } else {
            str = str.concat("CM");
        }

        if (on == 5) {
            str = str.concat("L");
        } else if (on == 4) {
            str = str.concat("XL");
        } else if (on < 4) {
            str = str.concat("X".repeat(on));
        } else if (on < 9) {
            str = str.concat("L");
            str = str.concat("X".repeat(on - 5));
        } else {
            str = str.concat("XC");
        }

        if (num == 5) {
            str = str.concat("V");
        } else if (num == 4) {
            str = str.concat("IV");
        } else if (num < 4) {
            str = str.concat("I".repeat(num));
        } else if (num < 9) {
            str = str.concat("V");
            str = str.concat("I".repeat(num - 5));
        } else {
            str = str.concat("IX");
        }
        return str;
    }
    */
    private static final String[] belowTwenty = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    /*
        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
     */
    private static final String[] belowHundred = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static int romanToInt(String s) {

        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'V':
                case 'X':
                    if ((i - 1) >= 0 && s.charAt(i - 1) == 'I') {
                        result += c == 'V' ? 4 : 9;
                        i--;
                    } else {
                        result += c == 'V' ? 5 : 10;
                    }
                    break;
                case 'L':
                case 'C':
                    if ((i - 1) >= 0 && s.charAt(i - 1) == 'X') {
                        result += c == 'L' ? 40 : 90;
                        i--;
                    } else {
                        result += c == 'L' ? 50 : 100;
                    }
                    break;
                case 'D':
                case 'M':
                    if ((i - 1) >= 0 && s.charAt(i - 1) == 'C') {
                        result += c == 'D' ? 400 : 900;
                        i--;
                    } else {
                        result += c == 'D' ? 500 : 1000;
                    }
                    break;
                case 'I':
                    result += 1;
                    break;
            }
        }
        return result;
    }

    public static String intToRoman(int num) {

        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        String[] code = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


        String sb = "";


        while (num > 0) {

            for (int i = 0; i < val.length; i++) {

                if (num >= val[i]) {

                    num -= val[i];
                    sb = sb.concat((code[i]));
                    break;
                }
            }
        }

        return sb;
    }

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    private static String helper(int num) {
        String result;
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num - 10];
        else if (num < 100) result = belowHundred[num / 10] + " " + helper(num % 10);
        else if (num < 1000) result = helper(num / 100) + " Hundred " + helper(num % 100);
        else if (num < 1000000) result = helper(num / 1000) + " Thousand " + helper(num % 1000);
        else if (num < 1000000000) result = helper(num / 1000000) + " Million " + helper(num % 1000000);
        else result = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        return result.trim();
    }

    public static String decodeMessage(String key, String message) {

        StringBuilder sb = new StringBuilder();
        char[] keyToActual = new char[128];
        keyToActual[' '] = ' ';
        char currChar = 'a';

        for (final char c : key.toCharArray())
            if (keyToActual[c] == 0)
                keyToActual[c] = currChar++;

        for (final char c : message.toCharArray())
            sb.append(keyToActual[c]);

        return sb.toString();
    }

    public static boolean checkIfPangram(String sentence) {
        String a = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < a.length(); i++) {
            if (sentence.indexOf(a.charAt(i)) == -1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("romanToInt(\"MCMXCIV\") = " + romanToInt("MCMXCIV"));

        System.out.println("intToRoman(1994) = " + intToRoman(1994));

        System.out.println(BigInteger.valueOf((long) Math.pow(2, 31)));

        System.out.println("numberToWords(1994) = " + numberToWords(1994));

        String decodeMessage = decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
        System.out.println("decodeMessage = " + decodeMessage);

        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
}
