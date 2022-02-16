package Day03.Solvings;

import java.io.*;


class Resulttt {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
    final StringBuilder sb = new StringBuilder();
        
    for (Character c : s.toCharArray()) {
        if (Character.isLetter(c)) {
            final int aNumberValue = Character.isUpperCase(c) ? 'A' : 'a';
            final int value = (c + k - aNumberValue) % 26;
            sb.append((char) (value + aNumberValue));
        } else {
            sb.append(c);
        }
    }
        
    return sb.toString();

    }

}

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        //int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Resulttt.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
