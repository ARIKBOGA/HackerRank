public class ZigzagConversion {

    public static String convert(String s, int numRows) {

        if (numRows == 1)
            return s;

        StringBuilder result = new StringBuilder();
        int count = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += count) {
                result.append(s.charAt(j));
                if (i != 0 && i != numRows - 1 && (j + count - 2 * i) < s.length()) {
                    result.append(s.charAt(j + count - 2 * i));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(convert("PAYPALISHIRING", 3));
    }
    // PHASIYIRPLIGAN
}
