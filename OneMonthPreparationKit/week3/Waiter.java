package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Waiter {

    static List<Integer> answers = new ArrayList<>();
    static List<Integer> primes = new ArrayList<>();
    static List<Integer> reminder = new ArrayList<>();

    static boolean isPrime(int n) {
        if (n == 2)
            return true;
        if (n < 2 || n % 2 == 0)
            return false;
        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static void recurs(List<Integer> number, int i) {
        reminder.clear();
        for (Integer num : number) {
            if (num % primes.get(i) == 0)
                answers.add(num);
            else reminder.add(num);
        }
    }

    public static List<Integer> waiter(List<Integer> number, int q) {
        primes.add(2);
        int x = 3;
        while (primes.size() < q) {
            if (isPrime(x))
                primes.add(x);
            x += 2;
        }
        recurs(number, 0);
        for (int i = 1; i < q; i++) {
            List<Integer> cv = new ArrayList<>(reminder);
            recurs(cv, i);
        }
        answers.addAll(reminder);
        return answers;
    }

    public static void main(String[] args) {
        System.out.println(waiter(new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7)), 3));
    }
}