import java.time.LocalDate;
import java.util.Scanner;


public class GetDay {

    public static String findDay(int d, int m, int y) {
        return LocalDate.of(y, m, d).getDayOfWeek().toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int day = scan.nextInt();
        int month = scan.nextInt();
        int year = scan.nextInt();

        String res = findDay(day, month, year);

        System.out.println(res);
    }
}