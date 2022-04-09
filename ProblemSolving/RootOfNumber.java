import java.util.Scanner;

public class RootOfNumber {
    public static double root(double d, int i) {
        double s = 0,
                end = d,
                mid, result,
                error = 0.001;
        do {
            mid = (s + end) / 2.0;
            result = Math.pow(mid, i);
            if (result > d) {
                end = mid;
            } else if (result < d) {
                s = mid;
            } else {
                return mid;
            }
        } while (Math.abs(result - d) >= error);
        return mid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the times of controls : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the number and the degree of the root with seperated a space : ");
            double d = sc.nextDouble();
            int r = sc.nextInt();
            double x = root(d, r);
            System.out.println(x + "   " + Math.pow(x, r));
        }
    }
}
