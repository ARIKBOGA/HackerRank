import java.io.IOException;
import java.util.Scanner;


public class JavaBigNumberPrimalityTest {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(scanner.nextBigInteger().isProbablePrime(100) ? "prime" : "not prime");
        } catch (NumberFormatException exception) {
            System.out.println("Exception");
            exception.printStackTrace();
        }
    }
}
