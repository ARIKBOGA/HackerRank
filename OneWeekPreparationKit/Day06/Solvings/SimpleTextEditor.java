package Day06.Solvings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        List<Character> l = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int q = sc.nextInt();
        for(int i=0;i<q;i++) {
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    String s = sc.next();
                    stack.push(sb.toString());
                    sb.append(s);
                    break;

                case 2:
                    int del = sc.nextInt();
                    stack.push(sb.toString());
                    sb.delete(sb.length()-del,sb.length());
                    break;
                case 3:
                    int index = sc.nextInt();
                    l.add(sb.charAt(index-1));
                    break;
                case 4:
                    sb = new StringBuilder(stack.pop());
                    break;
            }
        }
        for (Character character : l) System.out.println(character);
    }
}