package Day01.Solvings;

import java.io.*;
import java.text.DecimalFormat;
//import java.math.*;
//import java.security.*;
//import java.text.*;
import java.util.*;
//mport java.util.concurrent.*;
//import java.util.regex.*;

class Son {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        double countpos = 0, countneg = 0, countzero = 0;
        for (Integer integer : arr) {
            if (integer > 0) {
                countpos++;
            } else if (integer < 0) {
                countneg++;
            } else {
                countzero++;
            }
        }
        DecimalFormat df = new DecimalFormat("##.######");
        System.out.println(df.format(countpos / arr.size()));
        System.out.println(df.format(countneg / arr.size()));
        System.out.println(df.format(countzero / arr.size())); 
        
    }

}

public class PlusMinusDay01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Son.plusMinus(arr);

        bufferedReader.close();
    }
}
