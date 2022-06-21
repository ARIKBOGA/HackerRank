public class Pangram {
    public static String isPangram(String s) {
        int i = 0;
        char c = 'a';
        s = s.replaceAll(" ", "").toLowerCase().trim();
        while (s.contains(String.valueOf(c))) {
            i++;
            c++;
        }
        return i == 26 ? "pangram" : "not pangram";
    }


    public static String isPangram_2(String s) {
        return s.trim().toLowerCase().replace(" ", "").chars().distinct().count() == 26 ? "pangram" : "not pangram";
    }

    public static void main(String[] args) {
        long start = System.nanoTime();

        System.out.println(isPangram("      We promptly judged antique ivory buckles for the next prize       "));
        System.out.println(isPangram("      We promptly judged antique ivory buckles for the prize        "));

        long first = System.nanoTime() - start;
        System.out.println("first methods time: " + first);

        System.out.println(isPangram_2("    We promptly judged antique ivory buckles for the next prize     "));
        System.out.println(isPangram_2("    We promptly judged antique ivory buckles for the prize  "));

        long second = System.nanoTime() - first;
        System.out.println("second methods time: " + (System.nanoTime() - second));
    }
}