import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("java", "java", "c++", "c++", "C#"));
        System.out.println(myMethod(list));
        System.out.println();

        System.out.println("getOdds(1,12) = " + getOdds(1, 12));
        System.out.println("getOdds(2,12) = " + getOdds(2, 12));
        System.out.println("getOdds(1,11) = " + getOdds(1, 11));
        System.out.println("getOdds(2,12) = " + getOdds(2, 11));
        System.out.println("getOdds(12,11) = " + getOdds(12, 11));
        System.out.println("getOdds(12,12) = " + getOdds(12, 12));

    }

    static List<String> myMethod(List<String> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    static String getOdds(int min, int max) {

        StringBuilder builder = new StringBuilder();
        // avoid from the invalid entries
        if (min >= max) {
            return "Max must be greater than the Min!";
        } else if (min % 2 == 0) {  // if the min value is an even number, start to print form the next number
            builder.append(++min).append(" ");
        } else                      // if the min value is an odd number, start to print form the "min"
            builder.append(" ");

        while (min + 1 < max) { // increase and print the value by 2 in each iteration throughout the range between min-max
            builder.append((min += 2)).append(" ");
        }

        return builder.toString().trim();
    }
}