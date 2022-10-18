package week4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class QueriesWithFixedLength {
    public static List<Integer> solve(List<Integer> arr, List<Integer> queries) {

        List<Integer> result = new ArrayList<>();

        for (Integer d : queries) {

            PriorityQueue<Item> pq = new PriorityQueue<>();

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.size(); i++) {

                pq.add(Item.of(arr.get(i), i));

                while (pq.peek().getIndex() <= i - d) {
                    pq.poll();
                }

                if (i >= d - 1 && pq.peek().getValue() < min) {
                    min = pq.peek().getValue();
                }
            }

            result.add(min);
        }

        return result;
    }

    static class Item implements Comparable<Item> {
        private Integer value;
        private Integer index;

        public Item(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }

        public static Item of(Integer value, Integer index) {
            return new Item(value, index);
        }

        public int compareTo(Item item) {
            return this.value.compareTo(item.value) * -1;
        }

        public int getValue() {
            return this.value;
        }

        public int getIndex() {
            return this.index;
        }
    }
}