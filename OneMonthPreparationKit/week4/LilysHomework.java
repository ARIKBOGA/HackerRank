package week4;

import java.util.*;
import java.util.stream.IntStream;


public class LilysHomework {

    private static void swap(long[] array, int index1, int index2) {
        array[index1] = (array[index1] + array[index2]) - (array[index2] = array[index1]);
    }

    private static int swaps(long[] unsortedValues) {

        int swaps = 0;

        Map<Long, Integer> locations = new HashMap<>();
        for (int i = 0; i < unsortedValues.length; i++) {
            locations.put(unsortedValues[i], i);
        }

        long[] sortedValue = unsortedValues.clone();
        Arrays.sort(sortedValue);

        for (int i = 0; i < sortedValue.length; i++) {
            if (sortedValue[i] != unsortedValues[i]) {
                swaps++;

                int swapIndex = locations.get(sortedValue[i]);
                locations.put(unsortedValues[i], swapIndex);

                swap(unsortedValues, i, swapIndex);
            }
        }

        return swaps;
    }

    public static void main(String[] args) {

        long[] values = {3, 4, 2, 5, 1};


        long[] reverseValue = IntStream.rangeClosed(1, values.length).mapToLong(
                i -> values[values.length - i]).toArray();


        System.out.println(Math.min(swaps(values), swaps(reverseValue)));

    }
}