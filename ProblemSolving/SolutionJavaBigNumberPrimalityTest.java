import java.io.*;
import java.util.*;
/** import java.math.*;
import java.security.*;
import java.text.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList; */

public class SolutionJavaBigNumberPrimalityTest {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(scanner.nextBigInteger().isProbablePrime(100) ? "prime" : "not prime");
        }catch (NumberFormatException exception){
            System.out.println("Exception");
            exception.printStackTrace();
        }
    }
}
