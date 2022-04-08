package week3;

import java.util.Stack;

public class IsBalance {

    public static String isBalanced(String s) {
        if (s.startsWith("]") || s.startsWith(")") || s.startsWith("}"))
            return "NO";

        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                brackets.push(c);
            } else if (!brackets.empty() && (
                    (c == ')' && brackets.pop() != '(')
                            || (c == '}' && brackets.pop() != '{')
                            || (c == ']' && brackets.pop() != '['))
            ) {
                break;
            }
        }
        return brackets.isEmpty() ? "YES" : "NO";

    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced(")[()]("));
        System.out.println(isBalanced("{{[[(())]]}}"));
    }
}