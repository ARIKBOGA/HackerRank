package week1;

import java.util.List;

public class Mini_MaxSum {
    public static void miniMaxSum(List<Integer> arr) {
        long min=Long.MAX_VALUE, max=Long.MIN_VALUE, total=0;
        for (Integer i : arr) {
            total += i;
            min = (long) Math.min(i,min);
            max = (long) Math.max(i,max);
        }
        System.out.println(total-max +" "+ (total-min));
    }
}