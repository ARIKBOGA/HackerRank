import java.util.List;

public class Anagram {

    private static <T> int freq(List<T> list, T num) {
        int result = 0;
        for (T t : list) {
            if (t.equals(num))
                result++;
        }
        return result;
    }

    public static int anagram(String s) {

        if (s.length() % 2 != 0) return -1;

        int half = (s.length()) / 2;

        StringBuilder s1 = new StringBuilder(s.substring(0, half));
        StringBuilder s2 = new StringBuilder(s.substring(half));

        for (String c : s2.toString().split("")) {
            int index = s1.indexOf(c);
            if (index > -1) {
                s1.delete(index, index + 1);
            }
        }
        return s1.length();
    }

    public static void main(String[] args) {
        //System.out.println("anagram(\"abccde\") = " + anagram("abccde"));
        System.out.println("anagram(\"xaxbbbxx\") = " + anagram("xaxbbbxx"));

    }
}
