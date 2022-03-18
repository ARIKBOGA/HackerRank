
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Subset {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        for (int i = 0; i < s.size(); i++) {
            s.set(i, s.get(i) % k);
        }
        System.out.println(s);
        Collections.sort(s);
        System.out.println(s);
        int sum = 0;
        int count = 0;
        for (Integer i : s) {
            if(sum+i<=k){
                sum+=i;
            }else{
                break;
            }
            count++;
        }
        return count;
    }
}

public class NonDivisibleSubset {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] sTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sTemp[i]);
            s.add(sItem);
        }

        int result = Subset.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
