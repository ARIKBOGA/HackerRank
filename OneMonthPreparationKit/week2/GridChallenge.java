package week2;

import java.util.Arrays;
import java.util.List;

public class GridChallenge {
    public static String gridChallenge(List<String> grid) {
        for (int i = 0; i < grid.size(); i++) {
            char[] c = grid.get(i).toCharArray();
            Arrays.sort(c);
            String sorted = "";
            for (char d : c) {
                sorted += d;
            }
            grid.set(i, sorted);
        }
        for (int i = 0; i < grid.get(0).length(); i++) {
            for (int j = 0; j < grid.size() - 1; j++) {
                if (grid.get(j).charAt(i) > grid.get(j + 1).charAt(i)) return "NO";
            }
        }
        return "YES";
    }
}
