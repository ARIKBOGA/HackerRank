package Day04.Solvings;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Bitir {
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int total_bride = 0;
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
                ++total_bride;
            } else if (integer == third_pos) {
                ++third_pos;
                total_bride += 2;
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(total_bride);
    }
}
public class NewYearChaos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());
                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());
                Bitir.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
    }
}
