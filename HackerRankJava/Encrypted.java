public class Encrypted {
    public static String encryption(String s) {
        int col = (int) Math.ceil(Math.sqrt(s.length()));
        String word = "";
        for (int i = 0; i < col; i++) {
            int j = i;
            while (j < s.length()) {
                word += s.charAt(j);
                j += col;
            }
            word += " ";
        }
        return word.trim();
    }

    public static void main(String[] args) {
        System.out.println(encryption("haveaniceday"));
        System.out.println(encryption("feedthedog"));
        System.out.println(encryption("chillout"));
        System.out.println(encryption("ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots"));
        //System.out.println("ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots");
    }
}
