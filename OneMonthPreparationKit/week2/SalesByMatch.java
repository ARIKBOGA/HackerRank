package week2;

import java.util.List;

public class SalesByMatch {
    public static int sockMerchant(int n, List<Integer> list) {
        int[] ar= new int[101];
        for (int i : list) {
            ar[i]++;
        }
        int pairs =0;
        for (int i : ar) {
            pairs += i/2;
        }
        return pairs;
    }
}
