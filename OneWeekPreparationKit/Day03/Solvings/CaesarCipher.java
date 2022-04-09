package Day03.Solvings;

import java.io.*;


public class CaesarCipher {
    public static String caesarCipher(String s, int k) {

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

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}