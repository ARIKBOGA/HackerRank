package Day05.Solvings;

import java.util.*;

public class QueueWithTwoStacks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        ArrayList<Integer> stack1 = new ArrayList<Integer>();
        ArrayList<Integer> stack2 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int total_operations = sc.nextInt();
        int function = 0;
        int add_element = 0;
        while (total_operations > 0) {
            function = sc.nextInt();
            if (function == 1) {
                add_element = sc.nextInt();
                if (stack1.size() == 0 && stack2.size() == 0) {
                    stack1.add(add_element);
                } else {
                    stack2.add(add_element);
                }
            } else {
                if (stack1.size() == 0) {
                    while (stack2.size() != 0) {
                        stack1.add(stack2.get(stack2.size() - 1));
                        stack2.remove(stack2.size() - 1);
                    }
                }
                if (function == 2) {
                    stack1.remove(stack1.size() - 1);
                } else {
                    System.out.println(stack1.get(stack1.size() - 1));
                }
            }
            --total_operations;
        }
    }
}