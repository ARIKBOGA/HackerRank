package Day07.Solvings;


abstract class Uc implements Comparable<Uc> {
    public int frequency; // the frequency of this tree
    public char data;
    public Uc left, right;

    public Uc(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    public int compareTo(Uc tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends Uc {


    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}

class HuffmanUc extends Uc {

    public HuffmanUc(Uc l, Uc r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}


class TreeHoffmanDecoding {

/*
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;

*/

    void decode(String s, Uc root) {
        StringBuilder sb = new StringBuilder();
        Uc c = root;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i) == '1' ? c.right : c.left;
            if (c.left == null && c.right == null) {
                sb.append(c.data);
                c = root;
            }
        }
        System.out.print(sb);

    }
}