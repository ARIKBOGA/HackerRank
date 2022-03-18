package week1.MockTest;

import java.util.Collections;
import java.util.List;

public class FindMedyan {
    public static int findMedian(List<Integer> arr) {
        Collections.sort(arr);
        if (arr.size() % 2 == 0) {
            return (arr.get(arr.size() / 2) + arr.get(arr.size() / 2 - 1)) / 2;
        } else return arr.get(arr.size() / 2);
    }
}