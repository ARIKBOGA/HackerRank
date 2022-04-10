package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheMaxSubArray {
    public static List<Integer> maxSubarray(List<Integer> arr) {

        List<Integer> ans = new ArrayList<>();

        int curSum = 0, posSum = 0, maxSum = Integer.MIN_VALUE;
        int maxVal = Integer.MIN_VALUE;
        boolean allNeg = true;

        for (Integer i : arr) {
            if (i > 0)
                allNeg = false;
            curSum = Math.max(i, curSum + i);
            maxSum = Math.max(maxSum, curSum);

            posSum = Math.max(posSum, posSum + i);
            maxVal = Math.max(maxVal, i);
        }
        if (allNeg)
            posSum = maxVal;

        ans.add(maxSum);
        ans.add(posSum);
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, -1, 2, 3, 4, -5));

        System.out.println(maxSubarray(list));
    }
}