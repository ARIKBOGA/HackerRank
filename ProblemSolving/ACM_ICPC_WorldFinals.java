import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ACM_ICPC_WorldFinals {

    private static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static List<Integer> acmTeam(List<String> topic) {
        List<Integer> resultList = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < topic.size() - 1; i++) {
            for (int j = i + 1; j < topic.size(); j++) {
                int same = 0;
                for (int k = 0; k < topic.get(i).length(); k++) {
                    if (topic.get(i).charAt(k) == '1' || topic.get(j).charAt(k) == '1')
                        same++;
                }
                resultList.add(same);
                max = Math.max(same, max);
            }
        }
        List<Integer> returnList = new ArrayList<>();
        returnList.add(max);
        returnList.add(Collections.frequency(resultList, max));
        return returnList;
    }

    public static void main(String[] args) {
        /*
        10101
        11110
        00010
         */
        List<String> topic = Arrays.asList("10101", "11100", "11010", "00101");
        System.out.println("acmTeam(topic) = " + acmTeam(topic));
    }
}
