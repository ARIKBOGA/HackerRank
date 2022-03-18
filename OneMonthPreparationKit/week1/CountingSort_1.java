package week1;

import java.util.ArrayList;
import java.util.List;

public class CountingSort_1 {
    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            list.add(i, 0);
        }
        for (int i = 0; i < arr.size(); i++) {
            list.set(arr.get(i), list.get(i) + 1);
        }
        return list;
    }
}