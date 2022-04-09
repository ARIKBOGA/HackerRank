package Day01.Solvings;

import java.io.*;
import java.text.*;


public class TimeConversationDay01 {
    public static String timeConversion(String s) {
        // Write your code here
        DateFormat TWELVE_TF = new SimpleDateFormat("hh:mm:ssa");
        DateFormat TWENTY_FOUR_TF = new SimpleDateFormat("HH:mm:ss");
        try {
            return TWENTY_FOUR_TF.format(TWELVE_TF.parse(s));
        } catch (ParseException e) {
            return s;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
