import java.util.Arrays;
import java.util.List;

public class BeautifulTriplets {

    public static int beautifulTriplets(int d, List<Integer> arr) {

        int count = 0;

        for (Integer i : arr) {
            if (arr.contains(i + d) && arr.contains(i + 2 * d))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 2, 3, 4, 5);
        System.out.println("beautifulTriplets(1,list) = " + beautifulTriplets(1, list));
    }
}
