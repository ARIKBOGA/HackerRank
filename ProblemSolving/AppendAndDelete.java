
import java.io.*;

public class AppendAndDelete {
    public static String appendAndDelete(String s, String t, int k) {
        int commonLength = 0;

        for (int i = 0; i < java.lang.Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) == t.charAt(i))
                commonLength++;
            else
                break;
        }

        int i = s.length() + t.length() - 2 * commonLength;

        if (i > k) return "No";                                     //CASE A
        else if (i % 2 == k % 2) return "Yes";                      //CASE B
        else if ((s.length() + t.length() - k) < 0) return "Yes";   //CASE C
        else return "No";                                           //CASE D
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}