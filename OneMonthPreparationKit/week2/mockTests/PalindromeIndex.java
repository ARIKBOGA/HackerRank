package week2.mockTests;

public class PalindromeIndex {
    static int palindromeIndex(String s) {
        int l = s.length();
        int i, j, a, b;
        for (i = 0, j = l - 1; i < l; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                break;
        }
        if (i > j) return -1;

        for (a = i + 1, b = j; a < j && b > i + 1; a++, b--) {
            if (s.charAt(a) != s.charAt(b))
                return j;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(palindromeIndex("aaab"));
        System.out.println(palindromeIndex("baa"));
        System.out.println(palindromeIndex("aaa"));
        System.out.println(palindromeIndex("baba"));
    }
}
