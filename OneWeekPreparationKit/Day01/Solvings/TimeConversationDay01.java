package Day01.Solvings;

import java.io.*;
import java.text.*;

class Res {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
    DateFormat TWELVE_TF = new SimpleDateFormat("hh:mm:ssa");
    DateFormat TWENTY_FOUR_TF = new SimpleDateFormat("HH:mm:ss");
    try {
        return TWENTY_FOUR_TF.format(TWELVE_TF.parse(s));
    }catch (ParseException e) {
        return s;
    }

    }

}

public class TimeConversationDay01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Res.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
