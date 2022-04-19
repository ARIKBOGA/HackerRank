package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayManipulation {
    public static long arrayManipulation(int n, List<List<Integer>> queries) {

        long[] arr = new long[n];

        for (List<Integer> list : queries) {
            for (int i = list.get(0) - 1; i <= list.get(1) - 1; i++) {
                arr[i] += list.get(2);
            }
        }

        return Arrays.stream(arr).max().getAsLong();

    }


    public static long arrayManipulation2(int n, List<List<Integer>> queries) {
        long[] arr = new long[n];

        for (List<Integer> list : queries) {
            arr[list.get(0) - 1] += list.get(2);
            if (list.get(1) < n)
                arr[list.get(1)] -= list.get(2);
        }

        long sum = 0;
        long max = Long.MIN_VALUE;

        for (long i : arr) {
            sum += i;
            max = Math.max(sum, max);
        }

        return max;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<List<Integer>> listList = new ArrayList<>();

        int n = scan.nextInt();
        int m = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < m; i++) {
            listList.add(Arrays.stream(scan.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }


        System.out.println(arrayManipulation(n, listList));

        scan.close();
    }
}
