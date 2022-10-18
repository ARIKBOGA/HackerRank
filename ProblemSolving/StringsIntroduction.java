import java.util.Scanner;

public class StringsIntroduction {

    public static String capitalize(String A) {

        return A.substring(0, 1).toUpperCase() + A.substring(1).toLowerCase();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        sc.close();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());
        if (A.compareTo(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println(capitalize(A) + " " + capitalize(B));
    }
}