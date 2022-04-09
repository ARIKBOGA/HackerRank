//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import java.util.Scanner;

class SolutionJavaRegexIPValidation{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(MyRegex.pattern));
        }
        in.close();

    }
}

//IP adress validator regex code
class MyRegex {
    public static String pattern = "((\\d|\\d\\d|[0-1]\\d\\d|2[0-4][0-9]|25[0-5])\\.){3}(\\d|\\d\\d|[0-1]\\d\\d|2[0-4][0-9]|25[0-5])";
}
