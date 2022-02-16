package Day04.Solvings;

import java.io.*;

class Bul {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */
    public static int superDigit(String n, int k) {

        String sb = String.valueOf(calculatesum(n) * k);

        while (sb.length() > 1) {
            sb = String.valueOf(calculatesum(sb));
        }
        return Integer.parseInt(sb);
    }
    public static long calculatesum(String sb) {
        long sum = 0;
        //char[] carray = sb.toCharArray();
        for (int i = 0; i < sb.length(); i++) {
            sum = sum + Character.getNumericValue(sb.charAt(i));
        }
        return sum;
    }
}

public class RecursiveDigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Bul.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

