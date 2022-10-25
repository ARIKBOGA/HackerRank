public class TaumAndBday {

    public static long taumBday(long b, long w, long bc, long wc, long z) {
        return b * (Math.min(bc, wc + z)) +
                w * (Math.min(wc, bc + z));
    }

    public static void main(String[] args) {
        System.out.println("taumBday(3,4,12,5,2) = " + taumBday(3, 4, 12, 5, 2));
    }
}
