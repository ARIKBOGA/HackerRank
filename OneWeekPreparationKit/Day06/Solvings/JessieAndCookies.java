package Day06.Solvings;

import java.io.IOException;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class JessieAndCookies {
    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> cookies = new PriorityQueue<>();

        A.forEach(cookies::offer);

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

        Scanner scan = new Scanner(System.in);

        int k = scan.nextInt();

        List<Integer> A = Stream.of(scan.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = cookies(k, A);


    }
}

