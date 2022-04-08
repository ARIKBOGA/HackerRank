package week3;


import java.util.*;

public class SherlockAndValidString {

    public static String isValid(String s) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        System.out.println(map);
        List<Integer> freq = new ArrayList<>(map.values());
        System.out.println("freq = " + freq);
        int min = Collections.min(freq);
        if (min == 1) {
            if (freq.stream().filter(e -> e == min).count() == 1) {
                freq.remove(freq.indexOf(min));
                return (freq.stream().distinct().count() <= 1) ? "YES" : "NO";
            }
        }
        if (freq.stream().filter(e -> e > min).map(e -> e - min).reduce(0, Integer::sum) > 1) {
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        String str1 = "abcdefghhgfedecba";
        System.out.println(isValid(str1));
    }
}