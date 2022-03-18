package week1;

import java.util.List;

public class SubArrayDivision_1 {
    public static int birthday(List<Integer> s, int d, int m) {
        int result = 0;
        for (int i = 0; i <= s.size() - m; i++) {
            int total = 0;
            for (int j = i; j < i + m; j++) {
                total += s.get(j);
            }
            if (total == d) result++;
        }
        return result;
    }
}