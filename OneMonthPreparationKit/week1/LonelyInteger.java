package week1;

import java.util.List;

public class LonelyInteger {
    public static int lonelyinteger(List<Integer> a) {
        int x = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.indexOf(a.get(i)) == a.lastIndexOf(a.get(i))) x = a.get(i);
        }
        return x;
    }
}
