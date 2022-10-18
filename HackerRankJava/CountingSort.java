import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Sort {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            list.add(i, 0);
        }
        for (Integer integer : arr) {
            list.set(integer, list.get(integer) + 1);
        }
        return list;
    }

}

public class CountingSort {
    public static List<Integer> createList() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(Sort.countingSort(createList()));

    }
}