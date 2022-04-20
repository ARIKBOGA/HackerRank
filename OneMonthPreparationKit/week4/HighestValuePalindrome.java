package week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HighestValuePalindrome {
    public static String highestValuePalindrome(String s, int n, int k) {
        int need = 0;
        int tmp = k;

        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) need++;
        }
        if (need > k) return "-1";

        List<Boolean> sbool = new ArrayList<>();

        for (char ignored : s.toCharArray())
            sbool.add(false);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) < s.charAt(n - 1 - i)) {
                sb.append(s.charAt(n - 1 - i));
                tmp--;
            } else sb.append(s.charAt(i));
            if (s.charAt(i) != sb.charAt(i)) sbool.set(i, true);
        }
        if (tmp == 1 && n % 2 == 1) {
            sb.setCharAt(n / 2, '9');
            tmp--;
            sbool.set(n / 2, true);
        }

        for (int i = 0; i < n; i++) {
            if (tmp > 0 && (sb.charAt(i) != '9')) {
                sb.setCharAt(i, '9');

                if (!sbool.get(i)) {
                    tmp--;
                    sbool.set(i, true);

                }
                sb.setCharAt(n - 1 - i, '9');
                if (!sbool.get(n - 1 - i)) {
                    tmp--;
                    sbool.set(n - 1 - i, true);
                }
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        String str = scan.next();

        System.out.println(highestValuePalindrome(str, n, k));

    }
}
