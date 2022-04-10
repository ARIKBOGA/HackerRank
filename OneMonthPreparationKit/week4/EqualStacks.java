package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EqualStacks {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {

        int height1 = h1.stream().mapToInt(Integer::intValue).sum();
        int height2 = h2.stream().mapToInt(Integer::intValue).sum();
        int height3 = h3.stream().mapToInt(Integer::intValue).sum();

        while (true) {
            if (height1 == height2 && height1 == height3) return height1;
            int maxHeight = Math.max(height1, Math.max(height2, height3));
            if (height1 == maxHeight) {
                height1 -= h1.remove(0);
            } else if (height2 == maxHeight) {
                height2 -= h2.remove(0);
            } else {
                height3 -= h3.remove(0);
            }

        }
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(3, 2, 1, 1, 1));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(4, 3, 2));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(1, 1, 4, 1));

        System.out.println(equalStacks(l1, l2, l3));
    }
}
