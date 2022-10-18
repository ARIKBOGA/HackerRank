public class JumpingOnClouds {
    public static int jumpingOnClouds(int[] arr) {
        int jump = -1;
        for (int i = 0; i < arr.length; i++, jump++) {
            if (i < arr.length - 2 && arr[i + 2] == 0) i++;
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 1, 0, 0};
        System.out.println(jumpingOnClouds(arr));
    }
}