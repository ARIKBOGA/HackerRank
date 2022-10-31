public class StringToInteger_ATOI {

    public static int myAtoi(String s) {

        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();

        int first = 0;
        while (!Character.isDigit(chars[first]))
            first++;

        int last = first;
        while (last < chars.length && Character.isDigit(chars[last]))
            last++;

        if (first > 0 && (chars[first - 1] == '-' || chars[first - 1] == '+'))
            str.append(chars[first - 1]);

        str.append(s, first, last);


        long aLong = Long.parseLong(str.toString());
        return aLong > Integer.MAX_VALUE ? Integer.MAX_VALUE : aLong < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) aLong;
    }

    public static void main(String[] args) {
        //System.out.println("myAtoi(\"-41937865988 with words\" ) = " + myAtoi("-45988 -8 with words"));
        System.out.println("myAtoi(\"42\") = " + myAtoi("42"));
    }
}
