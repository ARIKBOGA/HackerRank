package Day02.Solvings;

import java.util.Scanner;

public class FlippingMatrix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Satır sayısını giriniz : ");
        int row = sc.nextInt();
        System.out.print("Sütun sayısını giriniz : ");
        int col = sc.nextInt();
        int[][] matrix = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int sum = 0;
        int size = matrix.length;
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size / 2; j++) {
                sum += Math.max(matrix[i][j], Math.max(matrix[i][size - 1 - j], Math.max(matrix[size - 1 - i][j], matrix[size - 1 - i][size - 1 - j])));
                System.out.println(sum);
            }
        }
        System.out.println(sum);
    }
}
