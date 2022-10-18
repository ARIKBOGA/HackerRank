import java.util.ArrayList;

public class CountAndSay {

    private ArrayList<ArrayList<Integer>> freqPairGenerator (String s){
        int n = s.length(), count;
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();

        for (int i=0; i<n; i++){
            count = 1;
            while((i<n-1) && s.charAt(i) == s.charAt(i+1)){
                count++;
                i++;
            }
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(count);
            pair.add(Integer.parseInt(""+s.charAt(i)));
            pairs.add(pair);
        }

        return pairs;
    }
    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }

        String res = countAndSay(n-1);
        ArrayList<ArrayList<Integer>> pairs = freqPairGenerator(res);

        StringBuilder ans = new StringBuilder();

        for (ArrayList<Integer> pair : pairs){
            ans.append(pair.get(0));
            ans.append(pair.get(1));
        }

        return ans.toString();
    }
}
