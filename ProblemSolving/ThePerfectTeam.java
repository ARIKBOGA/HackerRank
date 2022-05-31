import java.util.Arrays;

public class ThePerfectTeam {

    static int differentTeams(String str) {
        int[] arr = new int[5];
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'p':
                    arr[0]++;
                    break;
                case 'c':
                    arr[1]++;
                    break;
                case 'm':
                    arr[2]++;
                    break;
                case 'b':
                    arr[3]++;
                    break;
                case 'z':
                    arr[4]++;
                    break;
            }
        }
        Arrays.sort(arr);
        return arr[0];
    }

    public static void main(String[] args) {
        String s = "ppcmbzzbm";
        System.out.println(differentTeams(s));
    }
}
