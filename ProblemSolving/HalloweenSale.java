public class HalloweenSale {

    public static int howManyGames(int p, int d, int m, int s) {

        int count = 0;
        while (s - p >= 0) {
            s -= p;
            p = Math.max((p - d), m);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("howManyGames(20,3,6,80) = " + howManyGames(20, 3, 6, 80));
        System.out.println("howManyGames(20,3,6,85) = " + howManyGames(20, 3, 6, 85));
    }
}
