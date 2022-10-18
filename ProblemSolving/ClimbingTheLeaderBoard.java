import java.util.ArrayList;
import java.util.Scanner;

public class ClimbingTheLeaderBoard {

    public static void printScores(int[] scores, int[] alice) {
        ArrayList<Integer> places = new ArrayList<>();
        int place = 1;
        places.add(scores[0]);
        for (int i = 1; i < scores.length; i++) {
            int currPlace = place - 1;
            int currScore = scores[i];
            if (currScore != places.get(currPlace)) {
                place++;
                places.add(currScore);
            }
        }

        int currPlace = places.size() + 1;
        for (int j : alice) {
            currPlace = getPlace(currPlace, j, places);
            System.out.println(currPlace);
        }

    }

    public static int getPlace(int currPlace, int currScore, ArrayList<Integer> places) {
        for (int i = currPlace - 1; i > 0; i--) {
            int index = i - 1;
            if (currScore < places.get(index)) {
                return i + 1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        for (int scores_i = 0; scores_i < n; scores_i++) {
            scores[scores_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for (int alice_i = 0; alice_i < m; alice_i++) {
            alice[alice_i] = in.nextInt();
        }
        printScores(scores, alice);
    }
}