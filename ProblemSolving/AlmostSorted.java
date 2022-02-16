

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Bitiris {

    public static void almostSorted(List<Integer> arr) {
        // Write your code here
        boolean rev = false, swap = false;
        int s = -1, e = -1;
        int n = arr.size();

        if (n == 1) {
            System.out.println("yes");
            return;
        }
        if (n == 2) {
            System.out.println("yes");
            if (arr.get(0) > arr.get(1)) {
                System.out.println("swap 1 2");
            }
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                if (s == -1) {
                    s = i;
                    while (i < n - 1 && arr.get(i) > arr.get(i + 1)) {
                        i++;
                    }
                    if (i == s + 2) {
                        e = i;
                        swap = true; break;
                    }
                    if (i > s + 2) {
                        e = i;
                        rev = true; break;
                    } else {
                        if (i + 1 < n && arr.get(s) < arr.get(i + 1)) {
                            e = i;
                            swap = true; break;
                        }
                    }
                } else {
                    e = i + 1;
                    swap = true; break;
                }
            }
        }
        if (s == -1 && e == -1) {
            System.out.println("yes");
            return;
        }
        if (s != -1 && e == -1) {
            System.out.println("no");
            return;
        }
        int l = s, r = e;

        boolean checkswap = false, checkrev = false;
        if (swap) {
            int temp = arr.get(s);
            arr.set(s, arr.get(e));
            arr.set(e, temp);
            checkswap = true;
        }
        if (rev) {
            while (s < e) {
                int temp = arr.get(s);
                arr.set(s, arr.get(e));
                arr.set(e, temp);
                s++;
                e--;
            }
            checkrev = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                System.out.println("no");
                return;
            }
        }
        if (checkrev) {
            System.out.println("yes");
            System.out.println("reverse " + (l + 1) + " " + (r + 1));
            return;
        }
        if (checkswap) {
            System.out.println("yes");
            System.out.println("swap " + (l + 1) + " " + (r + 1));
            return;
        }
    }
}
public class AlmostSorted {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Bitiris.almostSorted(arr);

        bufferedReader.close();
    }
}
