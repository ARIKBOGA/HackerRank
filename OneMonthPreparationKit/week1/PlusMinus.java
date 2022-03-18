package week1;

import java.text.DecimalFormat;
import java.util.List;

public class PlusMinus {
    public static void plusMinus(List<Integer> arr) {
        DecimalFormat format = new DecimalFormat("##.######");
        double p = 0, n = 0, z = 0;
        for (Integer i : arr) {
            if (i < 0) n++;
            else if (i > 0) p++;
            else z++;
        }
        System.out.println(format.format(p / arr.size()));
        System.out.println(format.format(n / arr.size()));
        System.out.println(format.format(z / arr.size()));
    }
}