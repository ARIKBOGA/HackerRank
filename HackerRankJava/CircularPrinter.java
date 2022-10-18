public class CircularPrinter {
    public static int getTime(String s) {
        s = s.replaceAll(" ", "").toLowerCase();
        char[] arr = s.toCharArray();
        int timer = 0;
        char pointer = 'a';
        for (char c : arr) {
            int diff = Math.abs(pointer - c);
            if (diff > 13) {
                timer += 26 - diff;
            } else {
                timer += diff;
            }
            pointer = c;
        }
        return timer;
    }

    public static void main(String[] args) {
        System.out.println("getTime(\"BZA\") = " + getTime("BZA"));
        System.out.println("getTime(\"AZGB\") = " + getTime("AZGB"));
    }
}
