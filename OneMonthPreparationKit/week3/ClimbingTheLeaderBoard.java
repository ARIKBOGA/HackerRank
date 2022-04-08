package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ClimbingTheLeaderBoard {   // test case 6,7,8,9 ends with time exceeding error on HackerRank.
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> list = ranked.stream().distinct().collect(Collectors.toList());
        List<Integer> ranks = new ArrayList<>(player.size());
        for (Integer i : player) {
            if (list.contains(i)) {
                ranks.add(list.indexOf(i) + 1);
            } else {
                list.add(i);
                list.sort(Collections.reverseOrder());
                ranks.add(list.indexOf(i) + 1);
            }
        }
        return ranks;
    }

    public static void main(String[] args) {
        List<Integer> ranked = new ArrayList<>(Arrays.asList(100, 100, 50, 40, 40, 20, 10));
        List<Integer> player = new ArrayList<>(Arrays.asList(5, 25, 50, 120));
        System.out.println(climbingLeaderboard(ranked, player));
    }
}
