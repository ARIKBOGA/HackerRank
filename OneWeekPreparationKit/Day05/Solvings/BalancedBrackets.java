package Day05.Solvings;

import java.io.*;
import java.util.Stack;
import java.util.stream.IntStream;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        char currChar, lastBracket;
        for (int i = 0; i < s.length(); i++) {
            currChar = s.charAt(i);
            if (currChar == '(' || currChar == '{' || currChar == '[') {
                stack.push(currChar);
            } else if (stack.isEmpty()) {
                return "NO";
            } else {
                lastBracket = stack.pop();
                if ((currChar == ')' && lastBracket != '(') ||
                        (currChar == '}' && lastBracket != '{') ||
                        (currChar == ']' && lastBracket != '[')) {
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = isBalanced(s);

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
