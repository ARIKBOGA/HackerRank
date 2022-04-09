package Day06.Solvings;

import java.io.*;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class JessieAndCookies {
    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> cookies = new PriorityQueue<>();

        A.forEach(element -> {
            cookies.offer(element);
        });

        int operations = 0;

        while (cookies.size() > 1 && cookies.peek() < k) {
            int leastSweetCookie = cookies.poll();
            int nextLeastSweetCookie = cookies.poll();
            int combinedCookie = leastSweetCookie + 2 * nextLeastSweetCookie;
            cookies.offer(combinedCookie);
            operations++;
        }
        if (cookies.peek() >= k) {
            return operations;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

