import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LonelyInteger {
    public static int lonelyinteger(List<Integer> a) {
        for (int r : a) {
            if (Collections.frequency(a, r) == 1) {
                return r;
            }
        }
        return 0;
    }

    public static int unique(List<Integer> a) {
        int x = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.indexOf(a.get(i)) == a.lastIndexOf(a.get(i))) x = a.get(i);
        }
        return x;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(1);
        System.out.println(unique(list));
        System.out.println(lonelyinteger(list));
    }
}
