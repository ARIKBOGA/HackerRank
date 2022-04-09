package Day01.Solvings;

import java.io.*;

import java.util.*;


public class MiniMaxSumDay01 {
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        long total = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
            }
            if (arr.get(i) > max) {
                max = arr.get(i);
            }
            total += arr.get(i);
        }
        System.out.println((total - max) + " " + (total - min));

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        System.out.println("kjjgj");
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        miniMaxSum(arr);

        bufferedReader.close();
    }
}
