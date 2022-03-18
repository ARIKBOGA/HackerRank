package week1;

import java.util.ArrayList;
import java.util.List;

public class SparseArray {
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> list = new ArrayList<>();
        for (String s : queries) {
            int c = 0;
            for (String q : strings) {
                if (s.equalsIgnoreCase(q)) c++;
            }
            list.add(c);
        }
        return list;
    }
}