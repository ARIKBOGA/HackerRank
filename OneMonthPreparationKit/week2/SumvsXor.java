package week2;

import java.util.SortedMap;

public class SumvsXor {
    public static long sumXor(long n) {
        if (n == 0) return 1;
        int zeros = (int) Long.toBinaryString(n).chars().filter(ch -> ch == '0').count();
        return (long) Math.pow(2, zeros);
    }

    public static void main(String[] args) {
        System.out.println(sumXor(347676575660L));
    }
}
