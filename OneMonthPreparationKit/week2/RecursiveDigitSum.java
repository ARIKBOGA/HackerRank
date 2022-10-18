package week2;

public class RecursiveDigitSum {
    public static int superDigit(String n, int k) {
        long sum = 0L;
        for (int i = 0; i < n.length(); i++) {
            sum += Long.parseLong(String.valueOf(n.charAt(i)));
        }
        sum *= k;
        if (sum < 10) return (int) sum;
        return superDigit(String.valueOf(sum), 1);
    }

    public static void main(String[] args) {
        System.out.println(superDigit("98755436565345224324554153213879655", 10000));
    }
}
