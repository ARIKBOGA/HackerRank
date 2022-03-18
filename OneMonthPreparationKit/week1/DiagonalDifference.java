package week1;

import java.util.List;

public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int total = 0;
        for (int i = 0, j = arr.size() - 1; i < arr.size(); i++, j--) {
            total += arr.get(i).get(i) - arr.get(i).get(j);
        }
        return Math.abs(total);
    }
}