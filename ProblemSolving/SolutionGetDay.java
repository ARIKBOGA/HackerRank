import java.io.*;
import java.time.LocalDate;

class Result {

    public static String findDay(int d, int m, int y) {
        LocalDate date = LocalDate.of(y, m, d);
        return date.getDayOfWeek().toString();
    }

}

public class SolutionGetDay {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int day = Integer.parseInt(firstMultipleInput[0]);
        int month = Integer.parseInt(firstMultipleInput[1]);
        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(day, month, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
