//import java.io.*;
import java.util.*;

public class SolutionJavaBigInteger {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
    Scanner sc = new Scanner(System.in);
    java.math.BigInteger ai = sc.nextBigInteger();
    java.math.BigInteger bi = sc.nextBigInteger();   
    sc.close(); 
    System.out.println(ai.add(bi));
    System.out.println(ai.multiply(bi));
    
    }
}