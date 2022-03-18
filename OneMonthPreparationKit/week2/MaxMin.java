package week2;

import java.util.Collections;
import java.util.List;

public class MaxMin {
    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        int min=Integer.MAX_VALUE;
        for (int i = 0, j = k - 1 ; j < arr.size(); i++, j++) {
            min = Math.min(min, arr.get(j) - arr.get(i));
        }
        return min;
    }
}