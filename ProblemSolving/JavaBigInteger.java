import java.math.BigInteger;
import java.util.Scanner;

public class JavaBigInteger {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BigInteger ai = sc.nextBigInteger();
        BigInteger bi = sc.nextBigInteger();

        sc.close();

        System.out.println(ai.add(bi));
        System.out.println(ai.multiply(bi));

    }
}