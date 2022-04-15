package week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TheMaxSubArray {
    public static List<Integer> maxSubarray(List<Integer> arr) {
        List<Integer> ans = new ArrayList<>();

        int curSum = 0, posSum = 0, maxSum = Integer.MIN_VALUE;
        int maxVal = Integer.MIN_VALUE;
        boolean allNeg = true;

        for (Integer integer : arr) {
            if (integer > 0)
                allNeg = false;
            curSum = Math.max(integer, curSum + integer);
            maxSum = Math.max(maxSum, curSum);
            posSum = Math.max(posSum, posSum + integer);
            maxVal = Math.max(maxVal, integer);
        }
        if (allNeg)
            posSum = maxVal;

        ans.add(maxSum);
        ans.add(posSum);
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(10) * (random.nextBoolean() ? 1 : -1));
        }
        System.out.println(maxSubarray(list));
    }
}