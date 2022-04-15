package week4;


import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class JessieAndCookies {

    /* All case passed */
    private static int cookies(int k, List<Integer> list) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(list);
        int count = 0;
        for (; queue.size() > 1 && queue.peek() < k; count++) {
            queue.add(queue.poll() + 2 * queue.poll());
        }
        return (queue.isEmpty() || queue.peek() >= k) ? count : -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        final int k = scan.nextInt();

        scan.nextLine();

        List<Integer> queue = Stream.of(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(cookies(k, queue));
    }
}