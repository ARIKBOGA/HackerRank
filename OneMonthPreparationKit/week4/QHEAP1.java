package week4;

import java.util.PriorityQueue;
import java.util.Scanner;

public class QHEAP1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        final int queries = Integer.parseInt(scan.nextLine());

        PriorityQueue<Integer> heapList = new PriorityQueue<>();

        for (int i = 0; i < queries; i++) {

            String str = scan.nextLine();
            String[] arr = str.split(" ");

            switch (arr[0]) {
                case "1":
                    heapList.offer(Integer.parseInt(arr[1]));
                    break;
                case "2":
                    heapList.remove(Integer.parseInt(arr[1]));
                    break;
                case "3":
                    System.out.println(heapList.element());
            }
        }
    }
}