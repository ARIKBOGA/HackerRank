public class ReverseInteger {

    public static int reverse(int x) {

        byte b = (byte) (x > 0 ? 1 : -1);
        x = Math.abs(x);
        long reversed = 0;
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return reversed > Integer.MAX_VALUE ? 0 : reversed < Integer.MIN_VALUE ? 0 : (int) reversed * b;
    }

    public static void main(String[] args) {
        System.out.println(reverse(342878759));
        System.out.println(reverse(1147483617));
        System.out.println(reverse(-123));
        System.out.println(reverse(Integer.MAX_VALUE));
    }
}
