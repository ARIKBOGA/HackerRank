import java.util.Scanner;

public class KaprekarNumbers {
    public static void kaprekarNumbers(int p, int q) {
        String result = "";
        for (int i = p; i <= q; i++) {
            long sqr = (long) i * i;
            String str = String.valueOf(sqr);
            String str_left = str.substring(0, str.length() / 2);
            String str_right = str.substring(str.length() / 2);
            int left = str_left.isEmpty() ? 0 : Integer.parseInt(str_left);
            int right = str_right.isEmpty() ? 0 : Integer.parseInt(str_right);
            if (left + right == i) {
                result += i + " ";
            }
        }
        System.out.println(result.isEmpty() ? "INVALID RANGE" : result.trim());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter first index: ");
        int p = scan.nextInt();
        System.out.print("Enter last index: ");
        int q = scan.nextInt();
        kaprekarNumbers(p, q);
    }
}