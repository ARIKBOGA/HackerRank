package week2;

public class DrawingBook {
    public static int pageCount(int n, int p) {
        int left = p / 2;
        int right = (n % 2 == 0 && p % 2 == 1) ? (n - p) / 2 + 1 : (n - p) / 2;
        return Math.min(left, right);
    }
}