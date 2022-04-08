package week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int queries = Integer.parseInt(scan.nextLine());

        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < queries; i++) {
            switch (scan.nextInt()) {
                case 1:
                    que.add(scan.nextInt());
                    if (i < queries - 1)
                        scan.nextLine();
                    break;
                case 2:
                    que.remove();
                    if (i < queries - 1)
                        scan.nextLine();
                    break;
                case 3:
                    System.out.println(que.peek());
                    if (i < queries - 1)
                        scan.nextLine();
                    break;
            }
        }
        scan.close();
    }
}