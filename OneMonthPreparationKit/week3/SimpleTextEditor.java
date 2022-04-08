package week3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {


    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder outString = new StringBuilder();

        StringBuilder text = new StringBuilder();

        int queries = Integer.parseInt(scan.nextLine());

        Stack<String> history = new Stack<>();


        for (int i = 0; i < queries; i++) {

            switch (scan.nextInt()) {
                case 1:
                    history.push(String.valueOf(text));
                    text.append(scan.next());
                    break;
                case 2:
                    history.push(String.valueOf(text));
                    text.delete(text.length() - scan.nextInt(), text.length());
                    break;
                case 3:
                    outString.append(text.charAt(scan.nextInt() - 1)).append("\n");
                    break;
                case 4:
                    if (!history.isEmpty())
                        text = new StringBuilder(history.pop());
                    break;
            }
        }
        buffer.write(outString.toString(), 0, outString.length());
        buffer.flush();
        buffer.close();
    }
}