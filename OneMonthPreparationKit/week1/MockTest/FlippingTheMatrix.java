package week1.MockTest;

import java.util.Arrays;
import java.util.List;

public class FlippingTheMatrix {
    public static int flippingMatrix(List<List<Integer>> matrix) {
        int[][] arr = new int[matrix.size()][matrix.get(0).size()];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = matrix.get(i).get(j);
            }
        }
        int sum = 0;
        int size = arr.length;
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size / 2; j++) {
                sum += Math.max(arr[i][j], Math.max(arr[i][size - 1 - j],
                        Math.max(arr[size - 1 - i][j], arr[size - 1 - i][size - 1 - j])));
                System.out.println(sum);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Integer[] array = (Integer[]) Arrays.stream(arr)
                .boxed()
                .toArray();


    }
}