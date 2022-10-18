package week1;

public class TimeConversion {
    public static String timeConversion(String s) {
        if (s.charAt(8) == 'A') {
            if (Integer.parseInt(s.substring(0, 2)) == 12) {
                return "00" + s.substring(2, 8);
            }
        } else if (s.charAt(8) == 'P') {
            if (Integer.parseInt(s.substring(0, 2)) != 12) {
                int hours = Integer.parseInt(s.substring(0, 2)) + 12;
                return "" + hours + s.substring(2, 8);
            }
        }
        return s.substring(0, 8);
    }
}