package Day01.Solvings;

import java.io.*;
import java.text.DecimalFormat;
//import java.math.*;
//import java.security.*;
//import java.text.*;
import java.util.*;


public class PlusMinusDay01 {
    public static void plusMinus(List<Integer> arr) {
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

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        plusMinus(arr);

        bufferedReader.close();
    }
}