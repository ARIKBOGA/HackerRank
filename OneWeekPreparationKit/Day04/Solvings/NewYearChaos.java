package Day04.Solvings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        int total_bribe = 0;
        int first_pos = 1;
        int second_pos = 2;
        int third_pos = 3;
        for (Integer integer : q) {
            if (integer == first_pos) {
                first_pos = second_pos;
                second_pos = third_pos;
                ++third_pos;
            } else if (integer == second_pos) {
                second_pos = third_pos;
                ++third_pos;
                ++total_bribe;
            } else if (integer == third_pos) {
                ++third_pos;
                total_bribe += 2;
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(total_bribe);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());
                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());
                minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
    }
}