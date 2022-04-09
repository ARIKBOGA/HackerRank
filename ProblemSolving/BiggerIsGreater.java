
import java.io.*;
import java.util.stream.*;


public class BiggerIsGreater {
    public static String biggerIsGreater(String str) {
        char[] chars = str.toCharArray();
        int i = chars.length - 1;
        while (i > 0) {
            if (chars[i - 1] >= chars[i]) {
                i--;
            } else {
                int j = i;
                while (j < chars.length && chars[j] > chars[i - 1]) {
                    j++;
                }
                char temp = chars[i - 1];
                chars[i - 1] = chars[j - 1];
                chars[j - 1] = temp;

                char[] newChar = new char[chars.length];
                System.arraycopy(chars, 0, newChar, 0, i); // Automatically copying array

                int end = chars.length - 1;
                for (int k = i; k < chars.length; k++) {
                    newChar[k] = chars[end--];
                }
                return new String(newChar);
            }
        }
        return "no answer";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}