package week2;

public class TowerBrakers {
    public static int towerBreakers(int n, int m) {
        return (m == 1 || n % 2 == 0 ? 2 : 1);
    }
}
