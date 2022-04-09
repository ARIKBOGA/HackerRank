import java.util.Scanner;

public class TypeCounter {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sentence = scan.nextLine();
        String[] words = sentence.split(" ");
        int i = 0, d = 0, str = 0;
        boolean iflag = true;
        boolean dflag = true;
        for (String word : words) {
            try {
                Integer.parseInt(word);
            } catch (NumberFormatException e1) {
                iflag = false;
            }
            if (!iflag) {
                try {
                    Double.parseDouble(word);
                } catch (NumberFormatException e2) {
                    dflag = false;
                }
            }
            if (iflag) i++;
            else if (dflag) d++;
            else str++;
            iflag = true;
            dflag = true;
        }
        System.out.println("string = " + str);
        System.out.println("integer = " + i);
        System.out.println("double = " + d);
    }//end of main

}//end of class