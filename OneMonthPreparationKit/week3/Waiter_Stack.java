package week3;

import java.util.*;

public class Waiter_Stack {
    public static int nextPrime(int num) {
        num++;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                num++;
                i = 2;
            }
        }
        return num;
    }

    public static List<Integer> waiter(List<Integer> number, int q) {
        // Write your code here
        int prime = 2;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> all = new Stack<>();
        Stack<Integer> divisible = new Stack<>();
        List<Integer> reverse = new ArrayList<>();

        for (int i : number) {
            all.push(i);
        }

        for (int j = 0; j < q; j++) {
            reverse.clear();
            while (!all.empty()) {
                if (all.peek() % prime == 0) {
                    divisible.push(all.pop());
                } else {
                    reverse.add(all.pop());
                }
            }

            while (!divisible.empty()) {
                result.add(divisible.pop());
            }

            for (int plate : reverse) {
                all.push(plate);
            }
            prime = nextPrime(prime);
        }

        if (reverse.size() > 0) {
            Collections.reverse(reverse);
            result.addAll(reverse);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(waiter(new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7)), 3));
    }
}
