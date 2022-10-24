import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumDistance {

    public static int minimumDistances(List<Integer> a) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(i).equals(a.get(j))) {
                    list.add(j - i);
                    break;
                }
            }
        }

        return list.size() > 0 ? Collections.min(list) : -1;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 1, 2, 3);
        List<Integer> list2 = Arrays.asList(7, 1, 3, 4, 1, 7);
        System.out.println("minimumDistances(list) = " + minimumDistances(list));
        System.out.println("minimumDistances(list2) = " + minimumDistances(list2));
    }

}
