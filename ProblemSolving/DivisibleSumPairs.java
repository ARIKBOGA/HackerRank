import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DivisibleSumPairs {

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j && ((ar.get(i) + ar.get(j)) % k == 0)) {
                    counter++;
                }
            }
        }
        return counter ;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] firstLine = scan.nextLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);

        String[] arTemp = scan.nextLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> ar = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arTemp[i]);
            ar.add(arItem);
        }
        System.out.println(divisibleSumPairs(n, k, ar));


    }
}
