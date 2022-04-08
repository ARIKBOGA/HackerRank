package week2;

import java.util.List;

public class SherlockAndArray {
    public static String balancedSums(List<Integer> arr) {
        int total = 0;
        for (Integer i : arr) {
            total += i;
        }
        int sum = 0;
        for (Integer i : arr) {
            if ((total - i) / 2 == sum) return "YES";
            sum += i;
        }
        return "NO";
    }
}